package com.androidstudio.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class masterdataLecturer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masterdata_lecturer)

        val btnadd = findViewById<Button>(R.id.btnadd)
        val menudashboard = findViewById<ImageButton>(R.id.menudashboard)

        menudashboard.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }

        btnadd.setOnClickListener{
            val intent = Intent(this,tambahlecturer::class.java)
            startActivity(intent)
        }
    }
}