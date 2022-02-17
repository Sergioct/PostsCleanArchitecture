package com.sergiocrespotoubes.postscleanarchitecture.presenter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.sergiocrespotoubes.postscleanarchitecture.presenter.ui.navigation.Navigation
import com.sergiocrespotoubes.postscleanarchitecture.presenter.ui.theme.PostsTheme
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun PostsApp(appState: PostsAppState = rememberPostsAppState()) {
	PostsTheme {
		Navigation(appState.navController)
	}
}
