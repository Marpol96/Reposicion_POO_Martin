package com.example.lycris_pol.Responce

import android.media.AudioTrack
// aqui en esta clase camos a manipular los atributos del artista,la cancion y el copyright
class resul (artista: artista?,track: tracks?,rightcopy: rightcopy?) {
    // declarando las variables como nulas al inicio
    var artista: artista?=null
    var track: tracks?=null
    var rightcopy:rightcopy?=null
    init {
        this.artista=artista
        this.track=track
        this.rightcopy=rightcopy
    }
}