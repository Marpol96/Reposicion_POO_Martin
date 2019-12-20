package com.example.lycris_pol
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.secundarylayout.*

class song :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secundarylayout)

        textView_artist.text=MainActivity.artist
        textView_song.text=MainActivity.song
        textView_Lyric.text=MainActivity.lyric
    }
}