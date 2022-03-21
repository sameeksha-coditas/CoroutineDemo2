package com.example.coroutinedemo2

import android.util.Log

object Logger {
    private const val tag = "Main"

    fun infoLog(msg: String) {
        Log.i(tag, msg)
    }
}