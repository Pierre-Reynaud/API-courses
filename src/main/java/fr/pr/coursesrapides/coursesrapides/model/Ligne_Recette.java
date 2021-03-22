package fr.pr.coursesrapides.coursesrapides.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Ligne_Recette {

    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "id",  insertable = false, updatable = false)
    private Recette recette;

    private float nombrepersonne;

    //endregion

    //region Constructeurs

    public Ligne_Recette() {
    }

    public Ligne_Recette(Ingredient ingredient, Recette recette, float nombrepersonne) {
        this.ingredient = ingredient;
        this.recette = recette;
        this.nombrepersonne = nombrepersonne;
    }

    //endregion

    //region Accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public float getNombrepersonne() {
        return nombrepersonne;
    }

    public void setNombrepersonne(float nombrepersonne) {
        this.nombrepersonne = nombrepersonne;
    }

    //endregion
}
