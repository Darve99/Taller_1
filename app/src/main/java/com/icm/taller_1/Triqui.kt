package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Triqui : AppCompatActivity() {

    private var turnoX = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triqui)
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        if (button.text.isEmpty()) {
            if (turnoX) {
                button.text = "X"
                button.backgroundTintList = resources.getColorStateList(R.color.paraEquis) // Cambio de color para "X"
            } else {
                button.text = "O"
                button.backgroundTintList = resources.getColorStateList(R.color.azulbase) // Cambio de color para "X"
            }
            turnoX = !turnoX
        }
    }

    fun onNewGameClick(view: View) {
        // Código para reiniciar el juego
        val buttons = listOf<Button>(
            findViewById(R.id.arribaIzquierda),
            findViewById(R.id.arribaCentro),
            findViewById(R.id.arribaDerecha),
            findViewById(R.id.centroIzquierda),
            findViewById(R.id.centroCentro),
            findViewById(R.id.centroDerecha),
            findViewById(R.id.abajoIzquierda),
            findViewById(R.id.abajoCentro),
            findViewById(R.id.abajoDerecha)
        )

        for (button in buttons) {
            button.text = ""
            button.backgroundTintList = resources.getColorStateList(R.color.azulbase)
        }

        turnoX = true
    }
}
