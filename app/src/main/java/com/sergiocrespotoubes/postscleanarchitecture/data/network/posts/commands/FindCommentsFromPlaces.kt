package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.commands

import arrow.fx.IO
import com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.models.CommentApi

/**
 * Created by Sergio Crespo Toubes on 10/02/2020.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface FindCommentsFromPlaces {

	companion object {
		const val URL = "/places"
	}

	fun findCommentsFromPosts(): IO<Response>

	data class Response(
		val comments: List<CommentApi> = emptyList()
	)
}
