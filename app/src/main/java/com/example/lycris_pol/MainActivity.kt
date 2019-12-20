package com.example.lycris_pol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.secundarylayout.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            button_buscar.setOnClickListener {
                setContentView(R.layout.secundarylayout)
                button_regresar.setOnClickListener {
                    setContentView(R.layout.activity_main)
                }
            }

        }
    fun recicle(){

    }
    }

