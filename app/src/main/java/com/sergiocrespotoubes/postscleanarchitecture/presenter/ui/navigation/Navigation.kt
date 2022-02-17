package com.sergiocrespotoubes.postscleanarchitecture.presenter.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.sergiocrespotoubes.postscleanarchitecture.presenter.ui.screens.splash.NavGraphs
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
	DestinationsNavHost(
		navController = navController,
		navGraph = NavGraphs.root
	)
}