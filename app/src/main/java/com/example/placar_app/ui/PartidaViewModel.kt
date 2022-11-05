package com.example.placar_app.ui

import androidx.lifecycle.ViewModel
import com.example.placar_app.data.PartidaRepository

class PartidaViewModel : ViewModel(){

    fun findPartidaStatement(partidaId: Int) =
        PartidaRepository.findPartidaStatement(partidaId)
}