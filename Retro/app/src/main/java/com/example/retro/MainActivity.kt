package com.example.retro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retro.ViewModels.PostsViewModel
import com.example.retro.ViewModels.TodosViewModel
import com.example.retro.ui.theme.RetroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RetroFitApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



//@Composable
//fun RetroFitApp(modifier: Modifier = Modifier){
//    val viewModel: TodosViewModel = viewModel()
//    val todos by viewModel.todos.collectAsState()
//
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Button(
//            onClick = {
//                viewModel.loadTodos()
//            }
//        ){
//            Text (text = "Fetch data")
//        }
//        LazyColumn(
//
//        ) {
//            items(items = todos){
//                todo ->
//                Text(
//                    text = "${todo.title} (${if (todo.completed) "done" else "pending"})",
//                    modifier = Modifier.padding(vertical = 8.dp)
//                )
//                HorizontalDivider()
//            }
//        }
//    }
//}

@Composable
fun RetroFitApp(modifier: Modifier = Modifier){
    val viewModel: PostsViewModel = viewModel()
    val posts by viewModel.posts.collectAsState()
    var id by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = {id = it}
        )
        Button(
            onClick = {
                viewModel.loadPosts()
            }
        ) {
            Text(text = "Load")
        }
        LazyColumn(

        ) {
            items(items = posts) {
                post ->
                Text(
                    text = "${post.title} ${post.body}",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetroTheme {
        RetroFitApp()
    }
}