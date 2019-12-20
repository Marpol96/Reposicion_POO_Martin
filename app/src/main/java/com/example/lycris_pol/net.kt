@file:Suppress("DEPRECATION")

package com.example.lycris_pol

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
// aqui en esta clase encontramos el la informacion de nuestra networkinfo
// para la conexion
class net {
    companion object{
        fun verifyConnection(activity: AppCompatActivity):Boolean{
            val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkinfo: NetworkInfo?
            networkinfo = connectivityManager.activeNetworkInfo

            return networkinfo != null && networkinfo.isConnected
        }
    }
}