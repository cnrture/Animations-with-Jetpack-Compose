package com.canerture.animationswithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canerture.animationswithjetpackcompose.ui.theme.AnimationsWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationsWithJetpackComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        AnimateFloatAsState()
                        Spacer(Modifier.height(32.dp))
                        AnimateDpAsState()
                        Spacer(Modifier.height(32.dp))
                        AnimateColorAsState()
                    }
                }
            }
        }
    }
}

@Composable
fun AnimateFloatAsState() {

    var animState by remember { mutableStateOf(false) }

    val animateValue by animateFloatAsState(
        if (animState) 0f else 1f,
        //if (animState) 180f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "Alpha Animation"
    )

    TitleText(title = "animateFloatAsState")

    Image(
        modifier = Modifier
            .alpha(animateValue)
            //.rotate(animateValue)
            .clickable { animState = !animState },
        painter = painterResource(id = R.drawable.icon_wtm),
        contentDescription = "WTM Icon"
    )
}

@Composable
fun AnimateDpAsState() {

    var animState by remember { mutableStateOf(false) }

    val animateValue by animateDpAsState(
        if (animState) 100.dp else (-100).dp,
        //if (animState) 140.dp else 96.dp,
        animationSpec = tween(durationMillis = 1000),
        //animationSpec = snap(1000),
        /*animationSpec = infiniteRepeatable(
            tween(1000),
            repeatMode = RepeatMode.Reverse
        ),*/
        label = "Offset Animation"
    )

    TitleText(title = "animateDpAsState")

    Image(
        modifier = Modifier
            .offset(animateValue)
            //.size(animateValue)
            .clickable { animState = !animState },
        painter = painterResource(id = R.drawable.icon_wtm),
        contentDescription = "WTM Icon"
    )
}

@Composable
fun AnimateColorAsState() {

    var animState by remember { mutableStateOf(false) }

    val animateValue by animateColorAsState(
        if (animState) colorResource(id = R.color.yellow) else Color.White,
        animationSpec = tween(durationMillis = 1000),
        label = "Color Animation"
    )

    TitleText(title = "animateColorAsState")

    Image(
        modifier = Modifier
            .background(animateValue)
            .clickable { animState = !animState },
        painter = painterResource(id = R.drawable.icon_wtm),
        contentDescription = "WTM Icon"
    )
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        color = Color.White,
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        colorResource(R.color.blue), colorResource(R.color.green)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationsWithJetpackComposeTheme {

    }
}