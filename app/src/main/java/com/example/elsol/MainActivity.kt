package com.example.elsol

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.runtime.mutableStateOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val tresPuntosMain = findViewById<ImageView>(R.id.tresPuntosMain)

        val datos = mutableListOf(
            CardItem(R.drawable.corona_solar, "Corona Solar"),
            CardItem(R.drawable.erupcionsolar, "Erupción Solar"),
            CardItem(R.drawable.espiculas, "Espículas"),
            CardItem(R.drawable.filamentos, "Filamentos"),
            CardItem(R.drawable.magnetosfera, "Magnetosfera"),
            CardItem(R.drawable.manchasolar, "Mancha Solar")
        )

        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = CardAdapter(datos)

        tresPuntosMain.setOnClickListener {
            val ventanaComparador: Intent = Intent(this, CompararPlanetas::class.java)
            startActivity(ventanaComparador)
        }

    }


}