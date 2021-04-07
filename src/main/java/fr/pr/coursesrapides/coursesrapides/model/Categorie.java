package fr.pr.coursesrapides.coursesrapides.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {

    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min=1, max=100)
    private String libelle;

    //endregion

    //region Constructeurs

    public Categorie(){

    }

    public Categorie(@Length(min = 1, max = 100) String libelle) {
        this.libelle = libelle;
    }

    public Categorie(int id, @Length(min = 1, max = 100) String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    //endregion

    //region Accesseurs


    public int getId() {
        return id;
    }

    public void setId(int id_categorie) {
        this.id = id_categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    //endregion


    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
