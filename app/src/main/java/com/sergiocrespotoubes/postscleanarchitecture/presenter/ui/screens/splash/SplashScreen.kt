package com.sergiocrespotoubes.postscleanarchitecture.presenter.ui.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

/**
 * Created by Sergio Crespo Toubes on 13/02/2022.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Destination(start = true)
@Composable
fun SplashScreen(navController: DestinationsNavigator) {

	val scaleAnimation: Animatable<Float, AnimationVector1D> =
		remember { Animatable(initialValue = 0f) }

	AnimationSplashContent(
		scaleAnimation = scaleAnimation,
		navController = navController,
		durationMillisAnimation = 1500,
		delayScreen = 3000L
	)

	/*DesignSplashScreen(
		imagePainter = painterResource(id =
		R.drawable.ic_launcher_background),
		scaleAnimation = scaleAnimation
	)*/
}

@Composable
fun AnimationSplashContent(
	scaleAnimation: Animatable<Float, AnimationVector1D>,
	navController: DestinationsNavigator,
	durationMillisAnimation: Int,
	delayScreen: Long
) {

	LaunchedEffect(key1 = true) {
		scaleAnimation.animateTo(
			targetValue = 0.5F,
			animationSpec = tween(
				durationMillis = durationMillisAnimation,
				easing = {
					OvershootInterpolator(3F).getInterpolation(it)
				}
			)
		)

		delay(timeMillis = delayScreen)

		//navController.navigate(MatchScreenDestination())
	}
}

@Composable
fun DesignSplashScreen(
	modifier: Modifier = Modifier,
	imagePainter: Painter,
	scaleAnimation: Animatable<Float, AnimationVector1D>
) {
	Box(
		modifier = modifier
			.fillMaxSize()
			.background(
				Brush.verticalGradient(
					colors = listOf(
						Color(239, 127, 26),
						Color(120, 40, 140),
						Color(0, 47, 187),
					)
				)
			),
		contentAlignment = Alignment.Center
	) {
		Column(horizontalAlignment = Alignment.CenterHorizontally) {
			Image(
				painter = imagePainter,
				contentDescription = "Logotipo Splash Screen",
				modifier = modifier
					.size(400.dp)
					.scale(scale = scaleAnimation.value),
			)

			Text(
				text = "Posts Clean Architecture",
				color = Color.White,
				fontSize = 40.sp,
				fontWeight = FontWeight.ExtraBold,
				fontFamily = FontFamily.Serif,
				textAlign = TextAlign.Center,
				modifier = modifier.scale(scale =
				scaleAnimation.value)
			)
		}
	}
}