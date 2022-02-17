package com.sergiocrespotoubes.postscleanarchitecture.presenter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Remembers and creates an instance of [PostsAppState]
 */
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@InternalCoroutinesApi
@Composable
fun rememberPostsAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): PostsAppState = remember(navController, coroutineScope) {
	PostsAppState(navController, coroutineScope)
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@InternalCoroutinesApi
class PostsAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
)
