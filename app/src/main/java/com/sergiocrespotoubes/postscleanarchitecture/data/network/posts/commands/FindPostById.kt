package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.commands

import arrow.core.Either
import com.sergiocrespotoubes.postscleanarchitecture.domain.posts.Post
import com.sergiocrespotoubes.postscleanarchitecture.domain.posts.PostId

/**
 * Created by Sergio Crespo Toubes on 10/02/2020.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface FindPostById {

	companion object {
		const val URL = "/places"
	}

	fun findPostById(postId: PostId): Either<Error, Post>

	class Error: Throwable()
}
