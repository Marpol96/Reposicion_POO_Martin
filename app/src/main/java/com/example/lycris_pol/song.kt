package com.example.lycris_pol
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.secundarylayout.*
// en esta clase que es song osea cancion es donde lo se ira a nuestro segundo
// layout y ubicara los siguientes campos
// nombre de artista, titulo de la song y la letra por defecto
class song :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secundarylayout)

        textView_artist.text=MainActivity.artist
        textView_song.text=MainActivity.song
        textView_Lyric.text=MainActivity.lyric
    }
}