package fr.pr.coursesrapides.coursesrapides.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Liste_Recette {

    //region Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date datedebut;

    private Date datefin;

    @OneToMany(targetEntity=Ligne_Liste.class, mappedBy="recette")
    private List<Ligne_Liste> ligne_listes = new ArrayList<>();

    //endregion

    //region Constructeurs

    public Liste_Recette(){

    }

    public Liste_Recette(Date datedebut, Date datefin) {
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    //endregion

    //region Accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id_) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public List<Ligne_Liste> getLigne_listes() {
        return ligne_listes;
    }

    //endregion
}
