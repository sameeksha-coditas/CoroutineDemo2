package com.example.coroutinedemo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            val time= measureTimeMillis {
                val answer1=networkCall1()
                val answer2=networkCall2()
                Logger.infoLog("Answer1 is $answer1")
                Logger.infoLog("Answer2 is $answer2")
            }
            Logger.infoLog("Requests took $time ms.")
        }
    }
    suspend fun networkCall1():String{
       delay(3000L)
        return "Answer 1"
    }
    suspend fun networkCall2():String{
        delay(3000L)
        return "Answer 2"
    }
}

