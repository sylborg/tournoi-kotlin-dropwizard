package fr.labs.sza.resources

import org.junit.jupiter.api.Test

internal class JoueurResourceTest {

    private val joueurResource: JoueurResource = JoueurResource()

    @Test
    fun getJoueurService() {
        // Given

        // When

        // Then
    }

    @Test
    fun getJoueurById() {
        // Given
        val id: Int = 0

        // When
        joueurResource.joueurService.getJoueurById(id)

        // Then
    }

    @Test
    fun getJoueurs() {
    }

    @Test
    fun getListeJoueurs() {
    }

    @Test
    fun getJoueurByPseudo() {
    }

    @Test
    fun addJoueur() {
    }

    @Test
    fun updateJoueur() {
    }

    @Test
    fun deleteJoueur() {
    }
}