package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.model.Todo
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.viewmodel.TodoViewModel

class MainActivity :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TodoTheme {

                //surface container using the background colour from the theme
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    TodoScreen()
                }
            }
        }
    }
}

@Composable
fun TodoList(todos: List<Todo>){
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ){
        items(todos){ todo->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}
@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()){
    TodoList(todoViewModel.todos)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    TodoTheme {
        TodoScreen()
    }
}

