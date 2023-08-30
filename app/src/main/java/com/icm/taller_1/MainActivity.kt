package com.icm.taller_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerIdiomas: Spinner = findViewById(R.id.idiomas)
        val botonTriqui: Button = findViewById(R.id.trici)
        val botonRandomGreet: Button = findViewById(R.id.random)
        val botonCountries: Button = findViewById(R.id.paises)

        botonTriqui.setOnClickListener{
            val intent = Intent(this, Triqui::class.java)
            startActivity(intent)
        }

        botonRandomGreet.setOnClickListener{
            val selectedLanguagePosition = spinnerIdiomas.selectedItemPosition
            val intent = Intent(this, RandomGreet::class.java)
            intent.putExtra("selectedLanguagePosition", selectedLanguagePosition)
            startActivity(intent)
        }

        botonCountries.setOnClickListener {
            val intent = Intent(this, Countries::class.java)
            startActivity(intent)
        }
    }
}
