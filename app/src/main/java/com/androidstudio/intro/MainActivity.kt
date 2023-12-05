package com.androidstudio.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnnext = findViewById<ImageButton>(R.id.btnnext)

        btnnext.setOnClickListener{
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }

    fun retrieveData() {

    }
}