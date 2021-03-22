package fr.pr.coursesrapides.coursesrapides.web.controller;

import fr.pr.coursesrapides.coursesrapides.dao.IngredientDao;
import fr.pr.coursesrapides.coursesrapides.model.Categorie;
import fr.pr.coursesrapides.coursesrapides.model.Ingredient;
import fr.pr.coursesrapides.coursesrapides.web.exceptions.IngredientCategorieIntrouvableException;
import fr.pr.coursesrapides.coursesrapides.web.exceptions.IngredientIntrouvableException;
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

@Api(tags = {"API Ingredient Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "API Ingredient Controller", description = "API pour les opérations CRUD sur les ingrédients.")
})
@RestController
public class IngredientController {

    @Autowired
    private IngredientDao ingredientDao;

    @ApiOperation(value = "Récupère la liste des ingrédients.")
    @GetMapping(value = "/Ingredients")
    public List<Ingredient> listeIngredient() {
        return ingredientDao.findAll();
    }

    @ApiOperation(value = "Récupère un ingrédient grâce à son ID.")
    @GetMapping(value = "/Ingredients/{id}")
    public Ingredient afficherUnIngredient(@PathVariable int id){
        Optional<Ingredient> ingredient = ingredientDao.findById(id);

        if (!ingredient.isPresent())
            throw new IngredientIntrouvableException("L'ingrédient avec l'id "+id+" est introuvable.");

        return ingredient.get();
    }

    @ApiOperation(value = "Récupère les ingrédients inclus dans la catégorie de l'ID passé en paramètre.")
    @GetMapping(value = "IngredientsByCategory/{idCategory}")
    public List<Ingredient> listByCategory(@PathVariable Categorie category) {
        List<Ingredient> ingredients = ingredientDao.findByCategorie(category);

        if (ingredients.size()<1)
            throw new IngredientCategorieIntrouvableException("Les ingrédients compris dans la catégorie "+category+" sont introuvables.");

        return ingredients;
    }

    @ApiOperation(value = "Supprime l'ingrédient dont l'ID est passé en paramètre.")
    @DeleteMapping(value = "Ingredients/{id}")
    public void supprimerIngredient(@PathVariable int id) {
        Optional<Ingredient> ingredient = ingredientDao.findById(id);

        if (!ingredient.isPresent())
            throw new IngredientIntrouvableException("L'ingrédient avec l'id "+id+" est introuvable.");

        ingredientDao.delete(ingredient.get());
    }

    @ApiOperation(value = "Met à jour l'ingrédient passé en paramètre.")
    @PutMapping(value = "/Ingredients")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    @ApiOperation(value = "Ajoute un nouvel ingrédient.")
    @PostMapping(value = "/Ingredients")
    public ResponseEntity<Void> ajouterIngredient(@RequestBody Ingredient ingredient) {
        Ingredient ingredientAdded = ingredientDao.save(ingredient);

        if (ingredientAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ingredientAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
