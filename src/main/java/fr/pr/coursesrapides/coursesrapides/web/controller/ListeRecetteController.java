package fr.pr.coursesrapides.coursesrapides.web.controller;

import fr.pr.coursesrapides.coursesrapides.dao.ListeRecetteDao;
import fr.pr.coursesrapides.coursesrapides.model.Liste_Recette;
import fr.pr.coursesrapides.coursesrapides.web.exceptions.ListeRecetteIntrouvableException;
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

@Api(tags = {"API ListeRecette Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "API ListeRecette Controller", description = "API pour les opérations CRUD sur les listes de recette.")
})
@RestController
public class ListeRecetteController {

    @Autowired
    private ListeRecetteDao listeRecetteDao;

    @ApiOperation(value = "Récupère la liste des listes de recette.")
    @GetMapping(value = "/ListesRecette")
    public List<Liste_Recette> listeListeRecette() {
        return listeRecetteDao.findAll();
    }

    @ApiOperation(value = "Récupère une liste de recette grâce à son ID.")
    @GetMapping(value = "/ListesRecette/{id}")
    public Liste_Recette afficherUneListeRecette(@PathVariable int id){
        Optional<Liste_Recette> listeRecette = listeRecetteDao.findById(id);

        if (!listeRecette.isPresent())
            throw new ListeRecetteIntrouvableException("La liste de recette avec l'id "+id+" est introuvable.");

        return listeRecette.get();
    }

    @ApiOperation(value = "Supprime la liste de recette dont l'ID est passé en paramètre.")
    @DeleteMapping(value = "ListesRecette/{id}")
    public void supprimerListeRecette(@PathVariable int id) {
        Optional<Liste_Recette> listeRecette = listeRecetteDao.findById(id);

        if (!listeRecette.isPresent())
            throw new ListeRecetteIntrouvableException("La liste de recette avec l'id "+id+" est introuvable.");

        listeRecetteDao.delete(listeRecette.get());
    }

    @ApiOperation(value = "Met à jour la liste de recette passé en paramètre.")
    @PutMapping(value = "/ListesRecette")
    public void updateIngredient(@RequestBody Liste_Recette listeRecette) {
        listeRecetteDao.save(listeRecette);
    }

    @ApiOperation(value = "Ajoute un nouvelle liste de recette.")
    @PostMapping(value = "/ListesRecette")
    public ResponseEntity<Void> ajouterListeRecette(@RequestBody Liste_Recette listeRecette) {
        Liste_Recette recetteListeAdded = listeRecetteDao.save(listeRecette);

        if (recetteListeAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(recetteListeAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
