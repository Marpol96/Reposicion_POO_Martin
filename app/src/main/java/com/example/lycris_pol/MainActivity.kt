package com.example.lycris_pol

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.secundarylayout.*
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.example.lycris_pol.Responce.artista
import java.net.CacheResponse
import com.google.gson.Gson

import com.android.volley.Request
import com.android.volley.Request.Method.GET
import com.example.lycris_pol.Responce.responceapi
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.*

class MainActivity : AppCompatActivity() {
    //inicio de mainactivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // hacemos el llamado al secundary layout para que nos lleve a la informacion
        // de la cancion buscada, constando de que los campos autor y titulo deben estar llenos
        button_buscar.setOnClickListener {
            if ((editText_Autor.text.toString() == "") || (editText_titulo.text.toString() == "")) {
                Toast.makeText(this,"Debe LLenar los campos solicitados para continuar!",Toast.LENGTH_SHORT).show()

            }else{
                setContentView(R.layout.secundarylayout)
                ready()
                button_regresar.setOnClickListener {
                    setContentView(R.layout.activity_main)
                }
            }
        }
        }
    // asignamos valores por defecto a algunas variables que nos van a servir
    // para manipular los valores de las mismas
    companion object InfoLyric {
        var artist: String = ""
        var song: String = ""
        var lyric: String = ""
        var rightcopies: String = ""
    }
    // aquo creamos esta funcion para cuando seleccionamos una cancion como favorita
    // asi esta misma se ira agregando al recycle view
    private fun cancionpopular() {
        textView_artist.text= artist
        textView_song.text= song
        textView_Lyric.text= lyric
        textView_copy.text= rightcopies
    }
    // esta es la funcion que verifica nuestra conexion con la api de lyrics que encontramos
    // tuve problemas al trabajar con otras Api asi que procedi a pedir ayuda
    private fun ready(){
        //si la conexion no se pudo establecer mostrar un mensaje notificando al usuario que
        //la conexion fallo
        if (net.verifyConnection((this))){
            httpVolley(getUrlApi(textView_artist.text.toString(),textView_song.text.toString()))
        }else{
            // mensaje por si la conexion a internet falla
            Toast.makeText(this,"Conecction to Internet is available",Toast.LENGTH_SHORT).show()
        }
    }
    // la funcion httpvolley
    private fun httpVolley(url:String){
        //primero instanceamos la cola de peticiones que se hacen
        val Queue=Volley.newRequestQueue(this)

        // en esta linea esperamos obtener una respuesta tipo string desde la URL enviada
        val stringRequest=StringRequest(Request.Method.GET, url,
            Response.Listener<String>{ response ->
                Log.d("HTTPVolley", response)
                //siempre mostrando mesnaje de apoyo para visualizar que nuestra app esta funcionando correctamente
                Toast.makeText(this,"Connection Perfect",Toast.LENGTH_SHORT).show()
                jsonToObject(response)

                val j=Intent(this, song::class.java)
                startActivity(j)
            },
            Response.ErrorListener{
                Log.d("HTTPVolley", "Error URL $url")
                Toast.makeText(this,"Connection failed",Toast.LENGTH_SHORT).show()
            })
        //aqui es donde se iran agregando las peticiones a la cola de peticines declara en la parte de arriba
        Queue.add(stringRequest)
    }
    // funcion en donde tomamos la URL de la API
    private fun getUrlApi(a:String,s:String):String{
        return "https://orion.apiseeds.com/api/music/lyric/$a/$s?apikey=8vdNcpE2X4vFjOzrf0DNOQNYQpGZqUgopNePSQdaJpsP1yp6swbGIbdWmzafzCAz"
    }
    //la funcion de JsonGson es la que nos ubicara en los objetos deseados los datos obtenidos de la API
    private fun jsonToObject(response: String){
        val gson= Gson()
        val apiResponse=gson.fromJson(response,responceapi::class.java)

        textView_artist.text=apiResponse.result?.artista?.name.toString()
        textView_song.text=apiResponse.result?.track?.name.toString()
        textView_Lyric.text=apiResponse.result?.track?.text.toString()
        textView_copy.text=apiResponse.result?.rightcopy?.text.toString()

    }
}