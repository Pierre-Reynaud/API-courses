package fr.pr.coursesrapides.coursesrapides.model;

import javax.persistence.*;

@Entity
public class Ligne_Liste {
    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id",  insertable = false, updatable = false)
    private Liste_Recette liste;

    @ManyToOne
    @JoinColumn(name = "id",  insertable = false, updatable = false)
    private Recette recette;

    private float nombrepersonne;

    //endregion

    //region Constructeurs

    public Ligne_Liste() {
    }

    public Ligne_Liste(Liste_Recette liste, Recette recette, float nombrepersonne) {
        this.liste = liste;
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

    public Liste_Recette getListe() {
        return liste;
    }

    public void setListe(Liste_Recette liste) {
        this.liste = liste;
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
