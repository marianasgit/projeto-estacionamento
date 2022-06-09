package com.example.fastparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
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
<<<<<<< HEAD

        binding.btnPesquisar.setOnClickListener { getVeiculo() }
    }

    private fun getVeiculo() {
        val url = "http://10.0.2.2/Projeto-Estacionamento-Teste-DB"
        val retrofitClient = retrofitInstance(url)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val placa = binding.pesquisar.text.toString()

        endpoint.getRegistro(placa).enqueue(object: Callback <JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val nomeCliente = response.body()?.get("nome_cliente")?.asString
                val modeloVeiculo = response.body()?.get("modelo_veiculo")?.asString
                val tempoTotal = response.body()?.get("tempo_total")?.asString
                val valorTotal = response.body()?.get("valor_total")?.asString

                val viewNome = findViewById<TextView>(R.id.nomeCliente)
                viewNome.text = "$nomeCliente"
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext, "Placa não encontrada", Toast.LENGTH_LONG)
            }
        })


=======
        
        binding.btnPesquisar.setOnClickLIstener { getVeiculo() }
    }
    
    private fun getVeiculo() {
        val url = "http://10.0.2.2  /Projeto-Estacionamento_Teste_DB"
        val retrofitClient = retrofitInstance(url)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val placa = binding.pesquisar.text.toString()
        
        endpoint.getVeiculo(placa).enqueue(object: Callback <JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>){
                val viewPlaca = response.body()?.get("message")?.asString
                val nomeCliente = response.body()?.get("message")?.asString
                val valorTotal = response.body()?.get("message")?.asString
                Picasso.get().load(viewPlaca).into(binding.card_placa)
            }
            
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro ao carregar veículo", Toast.LENGTH_LONG)
            }
        }
>>>>>>> 78b51e4ad59b3b30c04d77f1955d05211b0f79f9
    }


    private fun retrofitInstance(url: String): Retrofit {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    }
}
