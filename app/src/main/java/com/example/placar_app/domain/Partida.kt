package com.example.placar_app.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Partida(
    val id: Int,
    val time1: Time,
    val time2: Time,
    val pontoTime1: Int,
    val pontoTime2: Int,
    val resultTime1: ResultadoPartida,
    val resultTime2: ResultadoPartida,
    val status: StatusPartida
) : Parcelable
