package fr.pr.coursesrapides.coursesrapides.web.controller;

import fr.pr.coursesrapides.coursesrapides.dao.RecetteDao;
import fr.pr.coursesrapides.coursesrapides.model.Recette;
import fr.pr.coursesrapides.coursesrapides.web.exceptions.RecetteIntrouvableException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(tags = {"API Recette Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "API Recette Controller", description = "API pour les opérations CRUD sur les recettes.")
})
@RestController
public class RecetteController {

    @Autowired
    private RecetteDao recetteDao;

    @ApiOperation(value = "Récupère la liste des recettes.")
    @GetMapping(value = "/Recettes")
    public List<Recette> listeRecette() {
        return recetteDao.findAll();
    }

    @ApiOperation(value = "Récupère une recette grâce à son ID.")
    @GetMapping(value = "/Recettes/{id}")
    public Recette afficherUneRecette(@PathVariable int id){
        Optional<Recette> recette = recetteDao.findById(id);

        if (!recette.isPresent())
            throw new RecetteIntrouvableException("La recette avec l'id "+id+" est introuvable.");

        return recette.get();
    }

    @ApiOperation(value = "Supprime la recette dont l'ID est passé en paramètre.")
    @DeleteMapping(value = "Recettes/{id}")
    public void supprimerRecette(@PathVariable int id) {
        Optional<Recette> recette = recetteDao.findById(id);

        if (!recette.isPresent())
            throw new RecetteIntrouvableException("La recette avec l'id "+id+" est introuvable.");

        recetteDao.delete(recette.get());
    }

    @ApiOperation(value = "Met à jour la recette passé en paramètre.")
    @PutMapping(value = "/Recettes")
    public void updateIngredient(@RequestBody Recette recette) {
        recetteDao.save(recette);
    }

    @ApiOperation(value = "Ajoute un nouvelle recette.")
    @PostMapping(value = "/Recettes")
    public ResponseEntity<Void> ajouterRecette(@RequestBody Recette recette) {
        Recette recetteAdded = recetteDao.save(recette);

        if (recetteAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(recetteAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
