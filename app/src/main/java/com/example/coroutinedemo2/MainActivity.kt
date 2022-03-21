package com.example.coroutinedemo2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.coroutinedemo2.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding?.run {
            this.btnStartActivity.setOnClickListener {
                lifecycleScope.launch {
                    while (true)
                    {
                        delay(1000L)
                        Logger.infoLog("Still Running...")
                    }
                }
                GlobalScope.launch {
                    delay(5000L)
                    Intent(this@MainActivity,SecondActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

        }



    }
}

