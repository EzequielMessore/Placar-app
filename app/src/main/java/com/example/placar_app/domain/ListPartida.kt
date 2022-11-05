package com.example.placar_app.domain

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListPartida (
    var id: Int,
    var time1: Time,
    var time2: Time,
    var status: StatusPartida,
    val color: Int

) : Parcelable

