package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.commands

import arrow.core.Either
import com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.models.PostApi

/**
 * Created by Sergio Crespo Toubes on 10/02/2020.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface FindAnswers {

	companion object {
		const val URL = "/posts"
	}

	fun findAnswers(): Either<Error, Response>

	data class Response(
		val posts: List<PostApi> = emptyList()
	)

	class Error: Throwable()

}
