package fr.labs.sza.api

import com.fasterxml.jackson.annotation.JsonProperty
import fr.labs.sza.core.Point

class ClassementApi {

    internal constructor() {
        // Jackson deserialization
    }

    internal constructor(idTournoi: Int, nomTournoi: String, points: Map<Int, Point>): this() {
        this.rank = points
        this.nomTournoi = nomTournoi
        this.idTournoi = idTournoi
    }

    @get:JsonProperty
    var rank: Map<Int, Point> = emptyMap()

    @get:JsonProperty
    var idTournoi: Int = 0

    @get:JsonProperty
    var nomTournoi: String = ""
}