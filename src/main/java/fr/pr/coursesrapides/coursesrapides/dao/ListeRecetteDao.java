package fr.pr.coursesrapides.coursesrapides.dao;

import fr.pr.coursesrapides.coursesrapides.model.Liste_Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListeRecetteDao extends JpaRepository<Liste_Recette, Integer> {


}
