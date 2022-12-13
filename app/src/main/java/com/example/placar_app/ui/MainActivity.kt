package com.example.placar_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placar_app.adapter.PartidaAdapter
import com.example.placar_app.data.State
import com.example.placar_app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<PartidaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.srlListPartida.setOnRefreshListener { findPartidaEstado() }

        findPartidaEstado()
        buttonCadastrar()
    }

    private fun findPartidaEstado(){
        viewModel.findPartidaStatement(binding.rvMain.id).observe(this){ state ->
            when(state){
                is State.Error -> {
                    state.message?.let { Snackbar.make(binding.rvMain, it, Snackbar.LENGTH_LONG).show() }
                    binding.srlListPartida.isRefreshing = false
                }
                is State.Success -> {
                    binding.rvMain.adapter = state.data?.let { PartidaAdapter(it) }
                    binding.srlListPartida.isRefreshing = false
                }
                State.Wait -> binding.srlListPartida.isRefreshing = true
            }

        }
    }
    private fun buttonCadastrar(){
        binding.buttonCadastrarPartida.setOnClickListener {
            val intent = Intent(this@MainActivity, CadastrarPartida::class.java)
            startActivity(intent)
        }
    }

}