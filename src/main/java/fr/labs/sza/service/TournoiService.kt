package fr.labs.sza.service

import fr.labs.sza.api.ClassementApi
import fr.labs.sza.core.ComparatorPoint
import fr.labs.sza.core.Joueur
import fr.labs.sza.core.Point
import fr.labs.sza.core.Tournoi
import fr.labs.sza.db.JoueurDao
import fr.labs.sza.db.TournoiDao
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors
import kotlin.NoSuchElementException

class TournoiService {

    val tournoiDao = TournoiDao()

    val joueurDao = JoueurDao()

    fun getTournoiById(id: Int): Tournoi? {
        return tournoiDao.findById(id)
    }

    fun getTournois(): Map<Int, Tournoi>? {
        return tournoiDao.findAll()
    }

    fun getListeTournois(): List<Tournoi>? {
        var tournoiMap = tournoiDao.findAll()
        return tournoiMap.values.toList()
    }

    fun ajouterJoueurs(id: Int, joueurs: List<Joueur>) {
        val joueursExistants = joueurs.parallelStream().filter { joueurDao.findById(it.id) != null }
            .collect(Collectors.toList())
        tournoiDao.updateJoueurs(id, joueursExistants)
    }

    fun saveTournoi(tournoi: Tournoi){
        tournoiDao.saveOrUpdate(tournoi)
    }

    fun deleteTournoi(id: Int) {
        return tournoiDao.delete(id)
    }

    fun deleteJoueurs(id: Int) {
        return tournoiDao.deleteJoueurs(id)
    }

    fun getPointsParJoueur(idJoueur: Int, idTournoi: Int): Map<Int, Int> {
        val tournoiCourant = tournoiDao.findById(idTournoi)

        val joueurInscrit: Optional<Joueur> = tournoiCourant!!.joueurs.parallelStream()
            .filter { it.id == idJoueur }.findFirst()
        var pointsDuJoueur: Map<Int, Int>
        if (tournoiCourant == null || !joueurInscrit.isPresent) {
            throw NoSuchElementException("le joueur " + idJoueur
                    + " ou bien le tournoi " + idTournoi + " n'existent pas")
        } else {
            pointsDuJoueur = tournoiCourant.points.filter { it.key == joueurInscrit.get().id}
        }
        return pointsDuJoueur
    }

    fun updatePoints(idJoueur: Int, idTournoi: Int, points: Int) {
        val tournoiCourant = tournoiDao.findById(idTournoi)

        var joueurInscrit: Boolean = tournoiCourant!!.joueurs.parallelStream()
            .anyMatch { it.id == idJoueur }
        if (tournoiCourant == null || !joueurInscrit) {
           throw NoSuchElementException("le joueur " + idJoueur
                   + "ou bien le tournoi " + idTournoi + " n'existent pas")
        } else {
            tournoiCourant.points.putIfAbsent(idJoueur, points)
            tournoiDao.saveOrUpdate(tournoiCourant)
        }
    }

    fun getJoueurClassement(idTournoi: Int, idJoueur: Int): ClassementApi {
        val tournoiClassement = getTournoiClassement(idTournoi)
        tournoiClassement.rank = tournoiClassement.rank.filterValues { it.idJoueur == idJoueur }
        return tournoiClassement
    }

    fun getTournoiClassement(idTournoi: Int): ClassementApi {
        val tournoiCourant = tournoiDao.findById(idTournoi)
        var lastId = AtomicInteger(0)
        val points: SortedSet<Point> = tournoiCourant!!.points.map { Point(it.key, it.value) }
            .toSortedSet(ComparatorPoint)
        var mapRank: MutableMap<Int, Point> = mutableMapOf()
        points.stream().forEachOrdered { mapRank.put(lastId.incrementAndGet(), it) }
        return ClassementApi(idTournoi, tournoiCourant.nom, mapRank)
    }
}