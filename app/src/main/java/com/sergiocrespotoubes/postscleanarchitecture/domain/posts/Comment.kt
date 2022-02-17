package com.sergiocrespotoubes.postscleanarchitecture.domain.posts

import com.sergiocrespotoubes.postscleanarchitecture.presenter.util.Email
import com.sergiocrespotoubes.postscleanarchitecture.presenter.util.Name

/**
 * Created by Sergio Crespo Toubes on 14/01/2022.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
typealias CommentId = String

data class Comment (
	val name: Name,
	val email: Email,
	val body: String
)
