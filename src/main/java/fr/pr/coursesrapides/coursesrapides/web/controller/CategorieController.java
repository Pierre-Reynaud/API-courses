package fr.pr.coursesrapides.coursesrapides.web.controller;

import fr.pr.coursesrapides.coursesrapides.dao.CategorieDao;
import fr.pr.coursesrapides.coursesrapides.model.Categorie;
import fr.pr.coursesrapides.coursesrapides.web.exceptions.CategorieIntrouvableException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(tags = {"API Categorie Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "API Categorie Controller", description = "API pour les opérations CRUD sur les categories.")
})
@RestController
public class CategorieController {

    @Autowired
    private CategorieDao categorieDao;

    @ApiOperation(value = "Récupère la liste des catégories.")
    @GetMapping(value = "/Categories")
    public List<Categorie> listeCategorie() {
        return categorieDao.findAll();
    }

    @ApiOperation(value = "Récupère une catégorie grâce à son ID.")
    @GetMapping(value = "/Categories/{id}")
    public Categorie afficherUneCategorie(@PathVariable int id) {
        Optional<Categorie> categorie = categorieDao.findById(id);

        if (!categorie.isPresent())
            throw new CategorieIntrouvableException("La catégorie avec l'id "+id+" est introuvable.");

        return categorie.get();
    }

    @ApiOperation(value = "Supprime la categorie dont l'ID est passé en paramètre.")
    @DeleteMapping(value = "Categories/{id}")
    public void supprimerCategorie(@PathVariable int id) {
        Optional<Categorie> categorie = categorieDao.findById(id);

        if (!categorie.isPresent())
            throw new CategorieIntrouvableException("La catégorie avec l'id "+id+" est introuvable.");

        categorieDao.delete(categorie.get());
    }

    @ApiOperation(value = "Met à jour la catégorie passé en paramètre.")
    @PutMapping(value = "/Categories")
    public void updateCategorie(@RequestBody Categorie categorie) {
        Categorie categorieToUpdate = categorieDao.getOne(categorie.getId());
        BeanUtils.copyProperties(categorie, categorieToUpdate);
        categorieDao.save(categorieToUpdate);
    }

    @ApiOperation(value = "Ajoute une nouvelle catégorie.")
    @PostMapping(value = "/Categories")
    public ResponseEntity<Void> ajouterCategorie(@RequestBody Categorie categorie) {
        Categorie categorieAdded = categorieDao.save(categorie);

        if (categorieAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categorieAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
