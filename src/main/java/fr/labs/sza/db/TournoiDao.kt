package fr.labs.sza.db

import fr.labs.sza.core.Joueur
import fr.labs.sza.core.Tournoi
import java.util.concurrent.atomic.AtomicInteger

class TournoiDao {

    val tournois = hashMapOf(
        0 to Tournoi(id = 0, joueurs = listOf(), nom = "tournoiKotlin")
    )

    var lastId: AtomicInteger = AtomicInteger(tournois.size - 1)

    fun findById(id: Int): Tournoi? {
        return tournois[id]
    }

    fun findAll(): Map<Int, Tournoi> {
        return tournois
    }

    fun saveOrUpdate(tournoi: Tournoi) {
        var idTournoi = findById(tournoi.id)!!.id
        if (idTournoi == null) {
            idTournoi = lastId.incrementAndGet()
        }
        tournois[idTournoi] = tournoi
    }

    fun updateJoueurs(id: Int, joueurs: List<Joueur>) {
        var tournoi = tournois[id]
        if (tournoi != null) {
            tournoi.joueurs = joueurs
            tournois.put(id, tournoi)
        }
    }


    fun deleteJoueurs(id: Int) {
        tournois[id]!!.joueurs = emptyList()
        tournois[id]!!.points = mutableMapOf()
    }

    fun delete(id: Int) {
        tournois.remove(id)
    }
}