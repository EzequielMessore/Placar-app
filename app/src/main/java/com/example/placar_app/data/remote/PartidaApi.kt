package com.example.placar_app.data.remote

import com.example.placar_app.domain.ListPartida
import retrofit2.http.*

interface PartidaApi {

    @GET("partidas/ver-partidas")
    suspend fun findPartidas(@Query("id") accountHolder: Int): List<ListPartida>
}