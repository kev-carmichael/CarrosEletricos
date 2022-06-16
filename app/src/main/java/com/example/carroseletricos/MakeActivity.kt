package com.example.carroseletricos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.ui.MakeAdapter

class MakeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_make)
        recyclerView.adapter = MakeAdapter(this)


    }
}