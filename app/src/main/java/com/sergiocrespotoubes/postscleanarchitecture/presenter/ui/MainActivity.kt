package com.sergiocrespotoubes.postscleanarchitecture.presenter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : ComponentActivity() {
	@OptIn(InternalCoroutinesApi::class,
		androidx.compose.foundation.ExperimentalFoundationApi::class,
		androidx.compose.material.ExperimentalMaterialApi::class
	)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PostsApp()
		}
	}
}