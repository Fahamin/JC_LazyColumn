package com.forex.forexsignal.jetpackcomposeretrofithilt.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.forex.forexsignal.jetpackcomposeretrofithilt.model.Movie


@Preview
@Composable
fun MovieDetails( movie: Movie) {

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xcdb599),
                        Color(0xcdb599)

                    )
                )
            )
    )
    {
        Card(

            modifier = Modifier.padding(32.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(14.dp, 24.dp)
            ) {

                Image(
                    imageVector = Icons.Filled.BrokenImage,
                    contentDescription = "", modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(text = movie.imageUrl,
                fontFamily = FontFamily.Default,
                style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(14.dp))

                Text(text = movie.category,
                    fontFamily = FontFamily.Default,
                    style = MaterialTheme.typography.titleMedium)


            }
        }
    }

}


