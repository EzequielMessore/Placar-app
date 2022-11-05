package com.example.placar_app.data

import android.util.Log
import androidx.lifecycle.liveData
import com.example.placar_app.data.remote.PartidaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PartidaRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PartidaApi::class.java)
    }

    fun findPartidaStatement(partidaId: Int) = liveData{
        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findPartidas(partidaId)))
        }catch (e: Exception){
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}