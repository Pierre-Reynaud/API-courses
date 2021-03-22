package fr.pr.coursesrapides.coursesrapides.dao;

import fr.pr.coursesrapides.coursesrapides.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategorieDao extends JpaRepository<Categorie, Integer> {


}
