package com.example.elsol

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CompararPlanetas : AppCompatActivity() {
    val listaPlanetas = mutableListOf(
        Planeta("Mercurio", 0.382F, 0.387F, 5400),
        Planeta("Venus", 0.949F, 0.723F, 5250),
        Planeta("Tierra", 1.0F, 1.0F, 5520),
        Planeta("Marte", 0.53F, 1.542F, 3960),
        Planeta("Jupiter", 11.2F, 5.203F, 1350),
        Planeta("Saturno", 9.41F, 9.539F, 700),
        Planeta("Urano", 3.38F, 19.81F, 1200),
        Planeta("Neptuno", 3.81F, 30.07F, 1500),
        Planeta("Plutón", 0.18F, 39.44F, 5000)
    )
    @SuppressLint("MissingInflatedId", "ResourceType")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comparar_planestas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            listaPlanetas
        )

        val planeta1 = findViewById<AutoCompleteTextView>(R.id.SelectPlaneta1)
        val planeta2 = findViewById<AutoCompleteTextView>(R.id.SelectPlaneta2)
        val diametro1 = findViewById<TextView>(R.id.diaValPlan1)
        val diametro2 = findViewById<TextView>(R.id.diaValPlan2)
        val disSol1 = findViewById<TextView>(R.id.disValPlan1)
        val disSol2 = findViewById<TextView>(R.id.disValPlan2)
        val densidad1 = findViewById<TextView>(R.id.denValPlan1)
        val densidad2 = findViewById<TextView>(R.id.denValPlan2)

        planeta1.setAdapter(adaptador)
        planeta2.setAdapter(adaptador)

        planeta1.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            diametro1.setText(planetaSeleccionado.diametro.toString())
            disSol1.setText(planetaSeleccionado.distanciaSol.toString())
            densidad1.setText(planetaSeleccionado.densidad.toString())

        }

        planeta2.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            diametro2.setText(planetaSeleccionado.diametro.toString())
            disSol2.setText(planetaSeleccionado.distanciaSol.toString())
            densidad2.setText(planetaSeleccionado.densidad.toString())

        }
    }
}