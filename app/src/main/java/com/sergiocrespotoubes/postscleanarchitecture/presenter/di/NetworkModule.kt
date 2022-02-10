package com.sergiocrespotoubes.postscleanarchitecture.presenter.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sergiocrespotoubes.postscleanarchitecture.BuildConfig
import com.sergiocrespotoubes.postscleanarchitecture.data.network.BaseService
import com.sergiocrespotoubes.postscleanarchitecture.data.network.BaseService.Companion.BASE_URL
import com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.PostsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by Sergio Crespo Toubes on 01/12/2021.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient {
		val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
			override fun checkClientTrusted(
				chain: Array<X509Certificate>,
				authType: String
			) { /* Unnused */
			}

			override fun checkServerTrusted(
				chain: Array<X509Certificate>,
				authType: String
			) { /* Unnused */
			}

			override fun getAcceptedIssuers(): Array<X509Certificate> =
				arrayOf() // arrayOf(X509Certificate()[0])
		})

		val trustManagerFactory =
			TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
		trustManagerFactory.init(null as KeyStore?)
		val trustManagers = trustManagerFactory.trustManagers
		val trustManager = trustManagers[0] as X509TrustManager
		val sslContext = SSLContext.getInstance("SSL")
		sslContext.init(null, trustAllCerts, null)
		val sslSocketFactory = sslContext.socketFactory
		val hostnameVerifier =
			HostnameVerifier { hostname, _ -> hostname in BaseService.trustedHosts }

		val builder = OkHttpClient.Builder()
		//builder.addInterceptor(TokenInterceptor())
		if (BuildConfig.DEBUG) {
			val interceptor = HttpLoggingInterceptor()
			interceptor.level = HttpLoggingInterceptor.Level.BODY
			builder.addInterceptor(interceptor)
		}
		builder.sslSocketFactory(sslSocketFactory, trustManager)
		builder.hostnameVerifier(hostnameVerifier)

		val requireTls12 = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
			.tlsVersions(TlsVersion.TLS_1_2)
			.build()
		builder.connectionSpecs(listOf(requireTls12))

		return builder
			.readTimeout(20, TimeUnit.SECONDS)
			.writeTimeout(20, TimeUnit.SECONDS)
			.connectTimeout(20, TimeUnit.SECONDS)
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
		val gson: Gson = GsonBuilder()
			.create()
		return Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create(gson))
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.build()
	}

	@Provides
	@Singleton
	fun provideVideoVisitsService(retrofit: Retrofit): PostsService {
		return retrofit.create(PostsService::class.java)
	}

}
