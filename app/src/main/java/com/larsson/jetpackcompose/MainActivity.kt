package com.larsson.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter = painterResource(id = R.drawable.skeletons)
            val painter2 = painterResource(id = R.drawable.hands)
            val description = "Two skeletons in love"
            val title = "Two skeletons in love"

            Column(modifier = Modifier
                // .border(BorderStroke(1.dp, Color.Red))
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                ImageRow(painter = painter, description = description, title = title)
                ImageRow(painter = painter2, description = description , title = title)
                ImageRow(painter = painter, description = description , title = title )
                ImageRow(painter = painter2, description = description , title = title )
            }

        }
    }

    @Composable
    fun ImageRow (
        painter: Painter,
        description: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Row(modifier = Modifier
            // .border(BorderStroke(2.dp, Color.Blue)),
        ) {
            Box(modifier = Modifier.weight(1f)) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )}
            Box(modifier = Modifier.weight(1f)) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )}

        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ) {

        Card(
            modifier = modifier
                //.width(200.dp) -
                .padding(20.dp)
                .border(BorderStroke(1.dp, Color.Magenta)),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }


    @Preview
    @Composable
    fun ComposablePreview() {

    }


}