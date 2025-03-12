package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Todo
import com.example.todo.model.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel(){

    //List of todos stored as mutable state
    var todos = mutableStateListOf<Todo>()
        private set

    init{
        getTodosList()
    }

    //function to fetch todos list
    private fun getTodosList(){
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e:Exception){
                Log.d("ERROR", e.message.toString())
            }
        }
    }
}