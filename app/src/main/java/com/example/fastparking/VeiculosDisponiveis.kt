package com.example.fastparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fastparking.api.Endpoint
import com.example.fastparking.databinding.ActivityVeiculosDisponiveisBinding
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VeiculosDisponiveis : AppCompatActivity() {
    lateinit var binding: ActivityVeiculosDisponiveisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVeiculosDisponiveisBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_veiculos_disponiveis)
    }


    private fun retrofitInstance(url: String): Retrofit {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    }
}