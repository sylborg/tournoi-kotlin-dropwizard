package fr.labs.sza.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class TournoiApi {

    constructor() {
        // Jackson deserialization
    }

    constructor(id: Int, nom: String): this() {
        this.id = id
        this.nom = nom
    }

    constructor(id: Int, pseudo: String, pointsTournoi: List<PointApi>): this(id, pseudo) {
        this.pointsTournoi = pointsTournoi
    }

    @get:JsonProperty
    var id: Int = 0

    @Length(max = 10)
    @get:JsonProperty
    var nom: String = ""

    @get:JsonProperty
    var pointsTournoi: List<PointApi> = arrayListOf()

}