package fr.pr.coursesrapides.coursesrapides.dao;

import fr.pr.coursesrapides.coursesrapides.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecetteDao extends JpaRepository<Recette, Integer> {


}
