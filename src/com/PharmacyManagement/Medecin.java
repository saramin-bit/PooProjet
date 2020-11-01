package com.PharmacyManagement;

public class Medecin {
    String nom;
    String prenom;
    String specialite;
    String adresse;
    boolean convontionné;

    public Medecin(String nomM, String prenomM, String specialite, String adresse, boolean conv) {
        this.nom=nom;
        this.prenom= prenom;
        this.specialite= specialite;
        this.adresse= adresse;
        this.convontionné=convontionné;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean isConvontionné() {
        return convontionné;
    }

    /*public void Medicament(String nom, String prenom, String specialite, String adresse, boolean convontionné){
        this.nom=nom;
        this.prenom= prenom;
        this.specialite= specialite;
        this.adresse= adresse;
        this.convontionné=convontionné;
    }*/
}
