package fr.labs.sza.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class JoueurApi {

    constructor() {
        // Jackson deserialization
    }

    constructor(id: Int, pseudo: String): this() {
        this.id = id
        this.pseudo = pseudo
    }

    constructor(id: Int, pseudo: String, pointsTournoi: List<PointApi>): this(id, pseudo) {
        this.pointsTournoi = pointsTournoi
    }

    @get:JsonProperty
    var id: Int = 0

    @Length(max = 10)
    @get:JsonProperty
    var pseudo: String = ""

    @get:JsonProperty
    var pointsTournoi: List<PointApi> = arrayListOf()

}