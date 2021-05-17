package fr.pr.coursesrapides.coursesrapides.web.controller;


import fr.pr.coursesrapides.coursesrapides.dao.CategorieDao;
import fr.pr.coursesrapides.coursesrapides.dao.IngredientDao;
import fr.pr.coursesrapides.coursesrapides.dao.ListeRecetteDao;
import fr.pr.coursesrapides.coursesrapides.dao.RecetteDao;
import fr.pr.coursesrapides.coursesrapides.model.Categorie;
import fr.pr.coursesrapides.coursesrapides.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "${WEBAPP}")
public class WebAppController {

    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private RecetteDao recetteDao;
    @Autowired
    private ListeRecetteDao listeRecetteDao;

    @GetMapping(value = "/index")
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping(value = "/liste")
    public String listerUnObjet(Model model, @RequestParam String objet) {

        List<Object> liste = null;
        String nameObjet = null;
        String nameBean = null;
        switch (objet) {
            case "categorie":
                nameObjet ="catégorie";
                nameBean = "Categorie";
                model.addAttribute("liste", categorieDao.findAll());

                break;
            case "ingredient":
                nameObjet ="ingrédient";
                nameBean = "Ingredient";
                model.addAttribute("liste", ingredientDao.findAll());

                break;
            case "recette":
                nameObjet ="recette";
                nameBean = "Recette";
                model.addAttribute("liste", recetteDao.findAll());

                break;
            case "listecourse":
                nameObjet ="liste de course";
                nameBean = "Liste_Course";
                model.addAttribute("liste", listeRecetteDao.findAll());

                break;
            default:
                nameObjet ="null";
                model.addAttribute("liste", null);
        }

        model.addAttribute("nameBean", nameBean);
        model.addAttribute("nameObjet", nameObjet);

        return "liste";
    }

    @GetMapping(value = "/delete")
    public String index(Model model, @RequestParam String typeObj, @RequestParam int id) {

        String message = "Objet : "+typeObj+" et id : "+id;

        model.addAttribute("message", message);

        return "ajax/testajax";
    }
}
