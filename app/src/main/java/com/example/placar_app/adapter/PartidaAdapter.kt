package com.example.placar_app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.placar_app.R
import com.example.placar_app.databinding.MainItemBinding
import com.example.placar_app.domain.ListPartida
import com.example.placar_app.domain.StatusPartida
import com.example.placar_app.ui.CadastrarPartida
import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class PartidaAdapter (private val dataSet: List<ListPartida>) : RecyclerView.Adapter<PartidaAdapter.ViewHolder>() {
    
    private val onClickListener: () -> Unit = {}

    class ViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {

            fun bind(item: ListPartida) = with(binding) {
                itemTxtNameTime1.text = item.time1.nome
                itemTxtNameTime2.text = item.time2.nome

                val stsPartida =
                    if (StatusPartida.AGUARDANDO == item.status) R.color.primary_100 else R.color.fundo_claro
                card.setBackgroundColor(stsPartida.toInt())
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.bind(item)

        viewHolder.itemView.setOnClickListener {
            onClickListener()
        }
    }

    override fun getItemCount() = dataSet.size
    
    fun setOnClickListener(listener: () -> Unit) {
        this.onClickListener = listener
    }
}
