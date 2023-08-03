package com.forex.forexsignal.jetpackcomposeretrofithilt.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.forex.forexsignal.jetpackcomposeretrofithilt.screens.MovieItemView
import com.forex.forexsignal.jetpackcomposeretrofithilt.model.Movie
import com.forex.forexsignal.jetpackcomposeretrofithilt.screens.AppBar
import com.forex.forexsignal.jetpackcomposeretrofithilt.ui.theme.JetpackComposeRetrofitHiltTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
           // mainViewModel.getMovieList()
        }

        setContent {
            JetpackComposeRetrofitHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomePage()

                }
            }
        }
    }

    @Composable
    private fun HomePage() {
        Column {
            Text(
                text = "Movie list App",
                textAlign = TextAlign.Center, modifier = Modifier
                    .padding(
                        8.dp, 24.dp
                    )
                    .fillMaxWidth(1f),
                style = MaterialTheme.typography.headlineMedium
            )

            MovieList(movieList = mainViewModel.movieListResponse)

        }
    }
}


@Composable
fun MovieList(movieList: List<Movie>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            MovieItemView(movie = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovieItem() {
    val movie = Movie(
        "Coco",
        "https://howtodoandroid.com/images/coco.jpg",
        "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
        "Latest"
    )
    MovieItemView(movie = movie, 0, 0) { i ->
    }
}

