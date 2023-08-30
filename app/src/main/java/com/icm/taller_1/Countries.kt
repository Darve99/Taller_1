package com.icm.taller_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Countries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val lista: ListView  = findViewById(R.id.list)

        val json = JSONObject(loadJSONFromAsset())
        val paisesJSONArray = json.getJSONArray("paises")

        val paisesList = ArrayList<String>()
        for (i in 0 until paisesJSONArray.length()) {
            val jsonObject = paisesJSONArray.getJSONObject(i)
            paisesList.add(jsonObject.getString("nombre_pais"))
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paisesList)
        lista.adapter = adapter

        lista.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val intent = Intent(baseContext, ShowCountries::class.java)
                intent.putExtra("num", id)
                startActivity(intent)
            }
        })

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