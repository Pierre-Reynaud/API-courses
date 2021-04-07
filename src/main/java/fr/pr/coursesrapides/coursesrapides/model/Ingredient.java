package fr.pr.coursesrapides.coursesrapides.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Ingredient {

    //region Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min=1, max=100)
    private String libelle;

    @Length(min=1, max=100)
    private String unitemesure;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    //endregion

    //region Constructeurs

    public Ingredient() {

    }

    public Ingredient(@Length(min = 1) String libelle, @Length(min = 1) String unitemesure, @Min(value = 1) Categorie categorie) {
        this.libelle = libelle;
        this.unitemesure = unitemesure;
        this.categorie = categorie;
    }

    public Ingredient(int id, @Length(min = 1, max = 100) String libelle, @Length(min = 1, max = 100) String unitemesure, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.unitemesure = unitemesure;
        this.categorie = categorie;
    }

    //endregion

    //region Accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getUnitemesure() {
        return unitemesure;
    }

    public void setUnitemesure(String unitemesure) {
        this.unitemesure = unitemesure;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    //endregion


    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", unitemesure='" + unitemesure + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
