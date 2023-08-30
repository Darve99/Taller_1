package com.icm.taller_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class RandomGreet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_greet)

        val selectedLanguagePosition = intent.getIntExtra("selectedLanguagePosition", 0)

        val greetTextView: TextView = findViewById(R.id.texto_saludo)
        val greetingsArray = resources.getStringArray(R.array.spinnerSaludos)
        val selectedGreeting = greetingsArray[selectedLanguagePosition]
        greetTextView.text = selectedGreeting
        val botoVolver: Button=findViewById(R.id.btnBackToMain)
        botoVolver.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
