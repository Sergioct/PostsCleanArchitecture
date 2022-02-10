package com.sergiocrespotoubes.postscleanarchitecture.domain.posts

/**
 * Created by Sergio Crespo Toubes on 14/01/2022.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
typealias UserId = Int
typealias PostId = Int

data class Post (
	val userId: UserId,
	val id : PostId,
	val title: String,
	val body: String
)

