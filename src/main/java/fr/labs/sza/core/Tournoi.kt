package fr.labs.sza.core

data class Tournoi(var id: Int, var joueurs: List<Joueur>, var nom: String) {

    var points: MutableMap<Int, Int> = mutableMapOf()

    constructor(points: MutableMap<Int, Int>, tournoi: Tournoi) : this(tournoi.id, tournoi.joueurs, tournoi.nom) {
        this.points = points
    }
}