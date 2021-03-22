package fr.pr.coursesrapides.coursesrapides.dao;

import fr.pr.coursesrapides.coursesrapides.model.Ligne_Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRecetteDao extends JpaRepository<Ligne_Recette, Integer> {
}
