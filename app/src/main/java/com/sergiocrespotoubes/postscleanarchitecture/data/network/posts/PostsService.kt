package com.sergiocrespotoubes.postscleanarchitecture.data.network.posts

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sergiocrespotoubes.postscleanarchitecture.data.db.entities.PostDb

interface PostsService {

	@Query("SELECT * from posts")
	fun findPosts(): LiveData<List<PostDb>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insert(posts: List<PostDb>)

	@Query("DELETE FROM posts")
	fun deleteAll()

}