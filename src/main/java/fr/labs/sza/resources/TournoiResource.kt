package fr.labs.sza.resources

import com.codahale.metrics.annotation.Timed
import fr.labs.sza.api.ClassementApi
import fr.labs.sza.api.JoueurApi
import fr.labs.sza.api.TournoiApi
import fr.labs.sza.core.Joueur
import fr.labs.sza.core.Tournoi
import fr.labs.sza.service.TournoiService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder
import kotlin.streams.toList

@Path("/tournoi")
@Produces(MediaType.APPLICATION_JSON)
class TournoiResource {

    val tournoiService = TournoiService()

    @GET
    @Path("{id}")
    @Timed
    fun getTournoiById(@PathParam("id") id: Int): Tournoi? {
        return tournoiService.getTournoiById(id)
    }

    @GET
    @Timed
    fun getTournois(): Map<Int, Tournoi>? {
        return tournoiService.getTournois()
    }

    @GET
    @Path("list")
    @Timed
    fun getListeTournois(): List<Tournoi>? {
        return tournoiService.getListeTournois()
    }

    @PUT
    @Path("{id}")
    @Timed
    fun addTournoi(@PathParam("id") id: Int, tournoiApi: TournoiApi): Response {
        var tournoi = Tournoi(id, listOf(), tournoiApi.nom)
        tournoiService.saveTournoi(tournoi)
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"tournoi ajouté avec succès \"}").build()
    }

    @POST
    @Path("{id}/ajouter/joueur")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    fun ajouterJoueur(@PathParam("id") id: Int, joueursApi: JoueurApi): Response {
        var joueurs = listOf(joueursApi).map { t: JoueurApi? ->  Joueur(t!!.id, t.pseudo)}.toList()
        tournoiService.ajouterJoueurs(id, joueurs)
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"joueur mis à jour avec succès \"}").build()
    }

    @POST
    @Path("{id}/ajouter/joueurs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    fun ajouterJoueurs(@PathParam("id") id: Int, joueursApi: List<JoueurApi>): Response {
        var joueurs = joueursApi.parallelStream().map { t: JoueurApi? -> Joueur(t!!.id, t.pseudo) }.toList()
        tournoiService.ajouterJoueurs(id, joueurs)
        return Response.status(Response.Status.CREATED).entity("{\"message\": \"joueurs mis à jour avec succès \"}").build()
    }

    @GET
    @Path("{idTournoi}/joueur/{idJoueur}/points")
    @Timed
    fun getPointsParJoueur(@PathParam("idJoueur") idJoueur: Int,
                           @PathParam("idTournoi") idTournoi: Int): Map<Int, Int> {
        return tournoiService.getPointsParJoueur(idJoueur, idTournoi)
    }

    @POST
    @Path("{idTournoi}/joueur/{idJoueur}/points/{points}")
    @Timed
    fun updatePoints(@PathParam("idJoueur") idJoueur: Int, @PathParam("idTournoi") idTournoi: Int,
                           @PathParam("points") points: Int): Response {
        tournoiService.updatePoints(idJoueur, idTournoi, points)
        return Response.status(Response.Status.CREATED).entity("{\"message\": " +
                "\"mise à jour effectué avec succès\"}").build()

    }

    @DELETE
    @Path("{id}")
    @Timed
    fun deleteTournoi(@PathParam("id") id: Int) {
        return tournoiService.deleteTournoi(id)
    }

    @DELETE
    @Path("{id}/joueurs")
    @Timed
    fun deleteJoueurs(@PathParam("id") id: Int) {
        return tournoiService.deleteJoueurs(id)
    }

    @GET
    @Path("{idTournoi}/classement")
    @Timed
    fun getClassement(@PathParam("idTournoi") idTournoi: Int): ClassementApi {
        return tournoiService.getTournoiClassement(idTournoi)
    }

    @GET
    @Path("{idTournoi}/joueur/{idJoueur}/classement")
    @Timed
    fun getClassement(@PathParam("idTournoi") idTournoi: Int,
                      @PathParam("idJoueur") idJoueur: Int): ClassementApi {
        return tournoiService.getJoueurClassement(idTournoi, idJoueur)
    }
}