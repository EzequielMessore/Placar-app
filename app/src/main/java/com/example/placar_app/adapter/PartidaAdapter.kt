package com.example.placar_app.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.placar_app.R
import com.example.placar_app.databinding.MainItemBinding
import com.example.placar_app.domain.ListPartida
import com.example.placar_app.domain.StatusPartida

class PartidaAdapter (private val dataSet: List<ListPartida>) : RecyclerView.Adapter<PartidaAdapter.ViewHolder>() {

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

        }

        override fun getItemCount() = dataSet.size

    }


