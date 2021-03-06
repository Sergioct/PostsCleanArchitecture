package com.sergiocrespotoubes.postscleanarchitecture.data.network

import com.sergiocrespotoubes.postscleanarchitecture.BuildConfig

/**
 * Created by Sergio Crespo Toubes on 10/02/2020.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
class BaseService {

	companion object {
		const val BASE_URL = BuildConfig.API_URL

		val trustedHosts: List<String> = listOf(
			"jsonplaceholder.typicode.com"
		)
	}

}