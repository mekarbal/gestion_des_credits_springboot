package com.spring_credit.start.models;


import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    private Long id;
    private String fName;
    private String lName;
    private String job;
    private String email;

    public Client(Long id, String fName, String lName, String job,String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.job = job;
        this.email=email;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
