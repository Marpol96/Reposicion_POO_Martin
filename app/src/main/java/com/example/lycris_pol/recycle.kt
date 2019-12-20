package com.example.lycris_pol
// esta clase la creamos deseando manioular los recycle
// pero se encontraron problemas para manipular los datos ya que la conexion
// con la api fallo en muchas ocaciones era inextable
class recycle(recycle_autor:String,recycle_titulo:String,recycle_letra:String) {
    var recycle_autor:String
    var recycle_titulo:String
    var recycle_letra:String

    init {
        this.recycle_autor=recycle_autor
        this.recycle_titulo=recycle_titulo
        this.recycle_letra=recycle_letra
    }

}