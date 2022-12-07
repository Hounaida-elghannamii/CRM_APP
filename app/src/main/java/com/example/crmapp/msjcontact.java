package com.example.crmapp;

public class msjcontact {
    private String name;
    private String gmail;
    private String sujet;
    private String msj;

    public msjcontact(String name, String gmail, String sujet, String msj) {
        this.name = name;
        this.gmail = gmail;
        this.sujet = sujet;
        this.msj = msj;
    }

    public String getName() {
        return name;
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

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
