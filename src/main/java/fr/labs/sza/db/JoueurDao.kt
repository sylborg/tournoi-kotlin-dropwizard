package fr.labs.sza.db

import fr.labs.sza.core.Joueur
import java.util.concurrent.atomic.AtomicInteger

class JoueurDao {

    val joueurs = hashMapOf(
        0 to Joueur(pseudo = "sylborg", id = 0),
        1 to Joueur(pseudo = "lorenita", id = 1)
    )

    var lastId: AtomicInteger = AtomicInteger(joueurs.size - 1)

    fun save(pseudo: String) {
        val id = lastId.incrementAndGet()
        joueurs.put(id, Joueur(pseudo = pseudo, id = id))
    }

    fun findById(id: Int): Joueur? {
        return joueurs[id]
    }

    fun findAll(): Map<Int, Joueur> {
        return joueurs
    }

    fun findByPseudo(pseudo: String): Joueur? {
        return joueurs.values.find { it.pseudo == pseudo }
    }

    fun update(id: Int, joueur: Joueur) {
        joueurs.put(id, Joueur(pseudo = joueur.pseudo, id = id))
    }

    fun delete(id: Int) {
        joueurs.remove(id)
    }
}