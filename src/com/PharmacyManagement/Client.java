package com.PharmacyManagement;

public class Client {
    private String nom,prenom;
    private int age;
    private int nss;
    boolean mc; // maladie chronique

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public int getNss() {
        return nss;
    }

    public boolean isMc() {
        return mc;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMc(boolean mc) {
        this.mc = mc;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }
    public Client(String nom , String prenom , int age , int nss , boolean mc){
        this.nom= nom;
        this.prenom= prenom;
        this.age= age;
        this.nss= nss;
        this.mc= mc;

    }
}
