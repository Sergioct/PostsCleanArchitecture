package com.sergiocrespotoubes.postscleanarchitecture.presenter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Sergio Crespo Toubes on 01/12/2021.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

	@Provides
	@ViewModelScoped
	fun provideAppointmentRepository(
		postsService: PostsService
	): PostsRepository {
		return PostsRepositoryImpl(appointmentService)
	}


}
