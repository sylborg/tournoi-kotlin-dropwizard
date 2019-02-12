package fr.labs.sza.resources

import com.codahale.metrics.annotation.Timed
import fr.labs.sza.core.Joueur
import fr.labs.sza.service.JoueurService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/joueur")
@Produces(MediaType.APPLICATION_JSON)
class JoueurResource {

    val joueurService = JoueurService()

    @GET
    @Path("{id}")
    @Timed
    fun getJoueurById(@PathParam("id") id: Int): Joueur? {
        return joueurService.getJoueurById(id)
    }

    @GET
    @Timed
    fun getJoueurs(): Map<Int, Joueur>? {
        return joueurService.getJoueurs()
    }

    @GET
    @Path("list")
    @Timed
    fun getListeJoueurs(): List<Joueur>? {
        return joueurService.getListeJoueurs()
    }

    @GET
    @Path("pseudo/{pseudo}")
    @Timed
    fun getJoueurByPseudo(@PathParam("pseudo") pseudo: String): Joueur? {
        return joueurService.getJoueurByPseudo(pseudo)
    }

    @PUT
    @Path("{pseudo}")
    @Timed
    fun addJoueur(@PathParam("pseudo") pseudo: String) {
        return joueurService.saveJoueur(pseudo)
    }

    @POST
    @Path("{id}/{pseudo}")
    @Timed
    fun updateJoueur(@PathParam("id") id: Int,
                     @PathParam("pseudo") pseudo: String) {
        return joueurService.updateJoueur(id, pseudo)
    }

    @DELETE
    @Path("{id}")
    @Timed
    fun deleteJoueur(@PathParam("id") id: Int) {
        return joueurService.deleteJoueur(id)
    }
}