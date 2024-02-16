package com.example.afconquiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.afconquiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000L)
        setContentView(R.layout.activity_main)
    }
}