package fr.labs.sza.core

data class Joueur(var id: Int, var pseudo: String) {

    var pointsTournoi: MutableList<Point> = mutableListOf()

    constructor(id: Int, pseudo: String, pointsTournoi: MutableList<Point>): this(id, pseudo) {
        this.pointsTournoi = pointsTournoi
    }
}