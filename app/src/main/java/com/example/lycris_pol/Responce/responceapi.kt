package com.example.lycris_pol.Responce
// esta clase nos dara el estado de la conexion de nuestra API
class responceapi(result: resul?, error: String) {
    var result: resul? = null
    var error: String? = ""
    init {
        this.result=result
        this.error=error
    }
}