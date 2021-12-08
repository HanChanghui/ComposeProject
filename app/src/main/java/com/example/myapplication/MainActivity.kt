package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

	private var list: ArrayList<Int> = arrayListOf()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		list.add(0)
		list.add(1)
		list.add(2)
		list.add(3)
		list.add(4)
		setContent {
			MyApplicationTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					boxsemple()
				}
			}
		}
	}
}
@Composable
fun boxsemple() {
	Box {
		var imageHeightPx by remember { mutableStateOf(0) }

		Image(
			painter = painterResource(R.drawable.ic_launcher_background),
			contentDescription = "I'm above the text",
			modifier = Modifier
				.fillMaxWidth()
				.onSizeChanged { size ->
					// Don't do this
					imageHeightPx = size.height
				}
		)
		Column {
			Text(
				text = "I'm below the image",
				modifier = Modifier.padding(
					top = with(LocalDensity.current) { imageHeightPx.toDp() }
				)
			)
			Text(
				text = "I'm below the image",
				modifier = Modifier.padding(
					top = with(LocalDensity.current) { imageHeightPx.toDp() }
				),
				color = Color.Cyan
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	MyApplicationTheme {
		boxsemple()
	}
}