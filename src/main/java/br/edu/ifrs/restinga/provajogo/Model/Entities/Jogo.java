package br.edu.ifrs.restinga.provajogo.Model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Jogo")
public class Jogo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private Date data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time1_id", nullable = false)
    private Time time1;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time2_id", nullable = false)
    private Time time2;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }
}
