package com.example.coroutinedemo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val job = GlobalScope.launch(Dispatchers.Default) {
            Logger.infoLog("Starting long running Calculation...")
            withTimeout(3000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Logger.infoLog("Result for i=$i: ${fib(i)}")
                    }
                }
            }
            Logger.infoLog("Ending long running Calculation...")
        }
    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}