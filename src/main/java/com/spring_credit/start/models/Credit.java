package com.spring_credit.start.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    private Long id;
    private String name;
    private double taux;

    public Credit(Long id, String name,double taux) {
        this.id = id;
        this.name = name;
        this.taux=taux;
    }

    public Credit() {
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taux=" + taux +
                '}';
    }
}
