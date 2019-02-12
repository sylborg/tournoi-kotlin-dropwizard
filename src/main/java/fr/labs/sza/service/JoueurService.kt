package fr.labs.sza.service

import fr.labs.sza.core.Joueur
import fr.labs.sza.db.JoueurDao

class JoueurService {

    val joueurDao = JoueurDao()

    fun getJoueurById(id: Int): Joueur? {
        return joueurDao.findById(id)
    }

    fun getJoueurs(): Map<Int, Joueur>? {
        return joueurDao.findAll()
    }

    fun getListeJoueurs(): List<Joueur>? {
        return this.getJoueurs()!!.values.toList()
    }

    fun getJoueurByPseudo(pseudo: String): Joueur? {
        return joueurDao.findByPseudo(pseudo)
    }

    fun saveJoueur(pseudo: String) {
        return joueurDao.save(pseudo)
    }

    fun updateJoueur(id: Int, pseudo: String) {
        return joueurDao.update(id, Joueur(id, pseudo))
    }

    fun deleteJoueur(id: Int) {
        return joueurDao.delete(id)
    }
}