package com.example.fastparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnPesquisarHome: Button = findViewById(R.id.btnPesquisarHome)


        fun abrirRegistro() {

            val intent = Intent(this, VeiculosDisponiveis::class.java)
            startActivity(intent)
            finish()
        }

        btnPesquisarHome.setOnClickListener {
            abrirRegistro() }
        }


}