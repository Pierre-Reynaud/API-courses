package fr.pr.coursesrapides.coursesrapides.dao;

import fr.pr.coursesrapides.coursesrapides.model.Categorie;
import fr.pr.coursesrapides.coursesrapides.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientDao extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByCategorie(Categorie categorie);
}
