package fr.pr.coursesrapides.coursesrapides.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Recette {

    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min=1, max=100)
    private String libelle;

    @Min(value = 1)
    private int nombrepersonne;

    @Length(min=1, max=150)
    private String lienrecette;

    @Length(min=1, max=500)
    private String description;

    @OneToMany(targetEntity=Ligne_Recette.class, mappedBy="recette")
    private List<Ligne_Recette> ligne_recettes = new ArrayList<>();



    //endregion

    //region Constructeurs

    public Recette(){

    }

    public Recette(@Length(min = 1, max = 100) String libelle, @Min(value = 1) int nombrepersonne, @Length(min = 1, max = 150) String lienrecette, @Length(min = 1, max = 500) String description) {
        this.libelle = libelle;
        this.nombrepersonne = nombrepersonne;
        this.lienrecette = lienrecette;
        this.description = description;
    }

    //endregion

    //region Accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id_recette) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombrepersonne() {
        return nombrepersonne;
    }

    public void setNombrepersonne(int nombrepersonne) {
        this.nombrepersonne = nombrepersonne;
    }

    public String getLienrecette() {
        return lienrecette;
    }

    public void setLienrecette(String lienrecette) {
        this.lienrecette = lienrecette;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ligne_Recette> getLigne_recettes() {
        return ligne_recettes;
    }

    //endregion


    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", nombrepersonne=" + nombrepersonne +
                ", lienrecette='" + lienrecette + '\'' +
                ", description='" + description + '\'' +
                ", ligne_recettes=" + ligne_recettes +
                '}';
    }
}
