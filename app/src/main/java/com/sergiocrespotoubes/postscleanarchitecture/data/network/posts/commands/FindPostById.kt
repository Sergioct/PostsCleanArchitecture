package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.commands

import arrow.fx.IO
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

	fun findPostById(postId: PostId): IO<Post>
}
