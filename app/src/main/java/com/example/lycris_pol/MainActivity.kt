package com.example.lycris_pol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.secundarylayout.*
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import android.os.Bundle
import com.example.lycris_pol.Responce.artista
import com.example.lycris_pol.Responce.responceapi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_buscar.setOnClickListener {
            ready()
        }
    }

    companion object InfoLyric {
        var artist: String = ""
        var song: String = ""
        var lyric: String = ""
        var rightcopies: String = ""
    }

    private fun cancionpopular() {
        textView_artist.text= artist
        textView_song.text= song
        textView_Lyric.text= lyric
        textView_copy.text= rightcopies
    }
    private fun ready(){
        if (net.verifyConnection((this))){
            httpVolley(getUrlApi(textView_artist.text.toString(),textView_song.text.toString()))
        }else{
            Toast.makeText(this,"Conecction to Internet is available",Toast.LENGTH_SHORT).show()
        }
    }
    private fun httpVolley(url:String){
        val depopol=Volley.newRequestdepopol(this)

        val stringRequest=StringRequest(Request.Method.GET,url,
            Response.Listener<String>{ response ->
                Log.d("HTTPVolley", response)
                Toast.makeText(this,"Connection Perfect",Toast.LENGTH_SHORT).show()
                jsonToObject(response)

                val j=Intent(this, song::class.java)
                startActivity(j)
            },
            Response.ErrorListener{
                Log.d("HTTPVolley", "Error URL $url")
                Toast.makeText(this,"Connection failed",Toast.LENGTH_SHORT).show()
            })
        depopol.add(stringRequest)
    }

    private fun getUrlApi(artista: String)
}