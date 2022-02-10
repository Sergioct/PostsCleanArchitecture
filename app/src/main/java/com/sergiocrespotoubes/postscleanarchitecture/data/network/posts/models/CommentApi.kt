package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts.models

import com.sergiocrespotoubes.postscleanarchitecture.domain.posts.Comment
import com.sergiocrespotoubes.postscleanarchitecture.domain.posts.CommentId
import com.sergiocrespotoubes.postscleanarchitecture.domain.posts.PostId
import com.sergiocrespotoubes.postscleanarchitecture.presenter.util.Email
import com.sergiocrespotoubes.postscleanarchitecture.presenter.util.Name

/**
 * Created by Sergio Crespo Toubes on 11/03/2020.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */

data class CommentApi(
	val postId: PostId,
	val commentId: CommentId,
	val name: Name,
	val email: Email,
	val body: String
){
	fun toDomain(): Comment {
		return Comment(
			name = name,
			email = email,
			body = body
		)
	}
}
