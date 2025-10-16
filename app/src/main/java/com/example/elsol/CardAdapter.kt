package com.example.elsol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val lista: MutableList<CardItem>) :
    RecyclerView.Adapter<CardAdapter.CargarDatos>() {

    class CargarDatos(view: View) : RecyclerView.ViewHolder(view) {
        val imgTresPuntosCard: ImageView = view.findViewById(R.id.tresPuntosCard)
        val imagen: ImageView = view.findViewById(R.id.imgCard)
        val texto: TextView = view.findViewById(R.id.textoID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CargarDatos {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return CargarDatos(view)
    }

    override fun onBindViewHolder(holder: CargarDatos, position: Int) {
        val item = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.texto.text = item.texto


        holder.imgTresPuntosCard.setOnClickListener {
            val popup = PopupMenu(holder.itemView.context, it)
            popup.menuInflater.inflate(R.menu.menu_card, popup.menu)

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.copiar -> {
                        lista.add(position, item.copy())
                        notifyItemInserted(position)
                        true
                    }
                    R.id.eliminar -> {
                        lista.removeAt(position)
                        notifyItemRemoved(position)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }

    }

    override fun getItemCount() = lista.size
}
