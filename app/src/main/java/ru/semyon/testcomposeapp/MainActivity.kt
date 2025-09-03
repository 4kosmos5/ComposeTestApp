package ru.semyon.testcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import ru.semyon.testcomposeapp.ui.theme.VkNewsClientTheme
import ru.semyon.testcomposeapp.ui.view.insta.InstagramProfileCard
import ru.semyon.testcomposeapp.ui.view.vk.MainScreen

class MainActivity : ComponentActivity() {

    private val instaViewModel by viewModels<InstaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    MainScreen()
                }
            }
        }
        /*setContent {
            VkNewsClientTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Test(viewModel)
                }
            }
        }*/
    }
}

@Composable
private fun Test(viewModel: InstaViewModel) {
    val models = viewModel.models.observeAsState(listOf())
    LazyVerticalGrid(columns =  GridCells.Fixed(2)) {
        items(models.value) { model ->
            InstagramProfileCard(model) {
                viewModel.changeFollowingStatus(it)
            }
        }
    }

}