package com.example.todo.model

import androidx.compose.ui.input.pointer.PointerId
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
   // @SerializedNameName("userId") var uId : Int,

    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

//Base URL for the todos API
const val BASE_URL = "https://jsonplaceholder.typicode.com"

interface TodosApi{

    //Retrofit GET request to fetch Todos
    @GET("todos")
    suspend fun getTodos(): List<Todo>
    fun clear()

    companion object{
        var todosService: TodosApi? = null

        fun getInstance():TodosApi{
            if (todosService === null){
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosService!!
        }
    }
}