package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Triqui : AppCompatActivity() {

    //Nombrar las variables para los turnos y los botones
    private var turnoX = true
    private val buttons = mutableListOf<Button>()

    //Funcion para crear el tablero
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triqui)

        buttons.addAll(
            listOf(
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
        )
    }

    //Funcion para verificar si hay un ganador
    private val winningCombinations = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Filas
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columnas
        listOf(0, 4, 8), listOf(2, 4, 6) // Diagonales
    )

    //Funcion para verificar si hay un ganador
    private fun checkForWinner(): String {
        for (combination in winningCombinations) {
            val (a, b, c) = combination
            if (buttons[a].text == buttons[b].text && buttons[a].text == buttons[c].text && buttons[a].text.isNotEmpty()) {
                return buttons[a].text.toString()
            }
        }
        return ""
    }

    //Funcion para asignar un 'X' o un 'O' a un boton
    fun onButtonClick(view: View) {
        val button = view as Button
        if (button.text.isEmpty()) {
            if (turnoX) {
                button.text = "X"
                button.backgroundTintList = resources.getColorStateList(R.color.paraEquis)
            } else {
                button.text = "O"
                button.backgroundTintList = resources.getColorStateList(R.color.azulbase)
            }
            turnoX = !turnoX

            val winner = checkForWinner()
            if (winner.isNotEmpty()) {
                val message = "¡$winner ha ganado!"
                showToast(message)
            }
        }
    }

    //Crear el toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    //Funcion para reiniciar el juego
    fun onNewGameClick(view: View) {
        for (button in buttons) {
            button.text = ""
            button.backgroundTintList = resources.getColorStateList(R.color.azulbase)
        }

        turnoX = true
    }
}
