package br.edu.ifrs.restinga.provajogo.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name="Time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTime")
    private int id;

    @Column(nullable = false)
    private String nomeTime;

    @Column(nullable = false)
    private String corCamisa;

    private int numeroGol;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getCorCamisa() {
        return corCamisa;
    }

    public void setCorCamisa(String corCamisa) {
        this.corCamisa = corCamisa;
    }

    public int getNumeroGol() {
        return numeroGol;
    }

    public void setNumeroGol(int numeroGol) {
        this.numeroGol = numeroGol;
    }


}
