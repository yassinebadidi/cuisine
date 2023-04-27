package fr.training.cuisine.ressource;

import com.sun.research.ws.wadl.Response;
import fr.training.cuisine.model.Recette;
import fr.training.cuisine.service.RecetteService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class RecettesRessource {
    RecetteService recetteService = new RecetteService();
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Recette> findAll(){
        return recetteService.fechAllRecettes();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Recette getPostById(@PathParam("id") int id){
        return recetteService.findById(id);
    }
}
