package com.example.carroseletricos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMarca: Button = findViewById(R.id.btnMarca)
        btnMarca.setOnClickListener {
            val makeIntent = Intent(this, MakeActivity::class.java)
            startActivity(makeIntent)
        }

        val btnPesquisa: Button = findViewById(R.id.btnPesquisa)
        btnPesquisa.setOnClickListener {
            val filterIntent = Intent(this, FilterActivity::class.java)
            startActivity(filterIntent)
        }



    }
}