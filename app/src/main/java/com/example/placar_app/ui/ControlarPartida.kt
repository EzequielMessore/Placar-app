package com.example.placar_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.placar_app.databinding.ActivityControlarPartidaBinding
import com.example.placar_app.domain.ListPartida
import com.example.placar_app.domain.Partida
import java.lang.IllegalArgumentException

class ControlarPartida : AppCompatActivity() {

//    companion object{
//        const val EXTRA_PARTIDA = "com.example.placar_app.ui.EXTRA_PARTIDA"
//    }
//    private val dadosPartidaId by lazy{
//        intent.getParcelableExtra<ListPartida>(EXTRA_PARTIDA) ?: throw IllegalArgumentException()
//    }
//
    private val binding by lazy { ActivityControlarPartidaBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}