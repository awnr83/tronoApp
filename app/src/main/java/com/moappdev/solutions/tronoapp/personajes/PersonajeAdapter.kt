package com.moappdev.solutions.tronoapp.personajes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moappdev.solutions.tronoapp.databinding.ItemCharacterBinding
import com.moappdev.solutions.tronoapp.network.House
import com.moappdev.solutions.tronoapp.network.Thrones
import com.moappdev.solutions.tronoapp.personajes.PersonajeAdapter.ViewHolder

class PersonajeAdapter(val clicListener: ClickListner): ListAdapter<Thrones, ViewHolder>(PersonajeCallback()) {
    class ViewHolder private constructor(val binding: ItemCharacterBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Thrones, clicListener: ClickListner) {
            binding.character= item
            binding.view.setBackgroundResource(House.getMaterial(item.house.name!!)[0])
            binding.click=clicListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup):ViewHolder {
                val layoutInflater= LayoutInflater.from(parent.context)
                val binding= ItemCharacterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class PersonajeCallback:DiffUtil.ItemCallback<Thrones>() {
        override fun areItemsTheSame(oldItem: Thrones, newItem: Thrones): Boolean {
            return oldItem.id===newItem.id
        }

        override fun areContentsTheSame(oldItem: Thrones, newItem: Thrones): Boolean {
            return oldItem==newItem
        }

    }

    class ClickListner(val clickListener:(personaje: Thrones)-> Unit){
        fun onClick(personaje: Thrones)= clickListener(personaje)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item,clicListener)
    }
}