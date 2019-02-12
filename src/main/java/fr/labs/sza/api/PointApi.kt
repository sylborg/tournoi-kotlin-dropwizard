package fr.labs.sza.api

import com.fasterxml.jackson.annotation.JsonProperty

class PointApi {

    constructor() {
        // Jackson deserialization
    }

    constructor(idJoueur: Int, idTournoi: Int, points: Int): this() {
        this.idJoueur = idJoueur
        this.idTournoi = idTournoi
        this.points = points
    }

    @get:JsonProperty
    var idJoueur: Int = 0

    @get:JsonProperty
    var idTournoi: Int = 0

    @get:JsonProperty
    var points: Int = 0
}