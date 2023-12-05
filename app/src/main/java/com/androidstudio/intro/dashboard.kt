package com.androidstudio.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RelativeLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val menumasterdata = findViewById<ImageButton>(R.id.menumasterdata)

        menumasterdata.setOnClickListener{
            val intent = Intent(this,masterdataLecturer::class.java)
            startActivity(intent)
        }
    }
}
