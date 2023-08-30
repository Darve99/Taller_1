package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class ShowCountries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_countries)

        val pos = intent.getLongExtra("num", -1)

        val imagenResource = when (pos.toInt()) {
            0 -> R.drawable.img_1
            1 -> R.drawable.img_2
            2 -> R.drawable.img_3
            3 -> R.drawable.img_4
            4 -> R.drawable.img_5
            5 -> R.drawable.img_6
            6 -> R.drawable.img_7
            7 -> R.drawable.img_8
            8 -> R.drawable.img_9
            9 -> R.drawable.img_10
            10 -> R.drawable.img_11
            11 -> R.drawable.img_12
            12 -> R.drawable.img_13
            13 -> R.drawable.img_14
            14 -> R.drawable.img_15
            15 -> R.drawable.img_16
            16 -> R.drawable.img_17
            17 -> R.drawable.img_18
            18 -> R.drawable.img_19
            19 -> R.drawable.img_20
            20 -> R.drawable.img_21
            21 -> R.drawable.img_22
            22 -> R.drawable.img_23
            23 -> R.drawable.img_24
            24-> R.drawable.img_25
            else -> R.drawable.img_0
        }

        val imageView = findViewById<ImageView>(R.id.foto)
        imageView.setImageResource(imagenResource)

        val json = JSONObject(loadJSONFromAsset())
        val paisesJSONArray = json.getJSONArray("paises")

        val paisesList = ArrayList<String>()
        for (i in 0 until paisesJSONArray.length()) {
            val jsonObject = paisesJSONArray.getJSONObject(i)
            paisesList.add(jsonObject.getString("nombre_pais"))
        }
        val pl: TextView = findViewById(R.id.texto1_1)
        pl.text = paisesList[pos.toInt()]

        val paisesListI = ArrayList<String>()
        for (i in 0 until paisesJSONArray.length()) {
            val jsonObject = paisesJSONArray.getJSONObject(i)
            paisesListI.add(jsonObject.getString("nombre_pais_int"))
        }
        val pli: TextView = findViewById(R.id.texto2_1)
        pli.text = paisesListI[pos.toInt()]

        val capitales = ArrayList<String>()
        for (i in 0 until paisesJSONArray.length()) {
            val jsonObject = paisesJSONArray.getJSONObject(i)
            capitales.add(jsonObject.getString("capital"))
        }
        val cap: TextView = findViewById(R.id.texto3_1)
        cap.text = capitales[pos.toInt()]

        val siglas = ArrayList<String>()
        for (i in 0 until paisesJSONArray.length()) {
            val jsonObject = paisesJSONArray.getJSONObject(i)
            siglas.add(jsonObject.getString("sigla"))
        }
        val sig: TextView = findViewById(R.id.texto4_1)
        sig.text = siglas[pos.toInt()]
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null

        try {
            val istream: InputStream = assets.open("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}