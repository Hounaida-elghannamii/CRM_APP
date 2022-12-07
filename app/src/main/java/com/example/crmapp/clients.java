package com.example.crmapp;

public class clients {
    private String name;
    private String gmail;
    private String numeroT;
    private String formation;
    //les constractures:
public clients(){}
    public clients(String name, String gmail, String numeroT,String formation) {
        this.name = name;
        this.gmail = gmail;
       this.numeroT= numeroT;
        this.formation= formation;

    }
//get/set
    public String getName() {
        return name;
    }
    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(String numeroT) {
        this.numeroT = numeroT;
    }
}
