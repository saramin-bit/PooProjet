package com.PharmacyManagement;

public class Medicament {
    private String nom;
    private double prix;
    private ModeDePrise mdp;
    private Type type;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ModeDePrise getMdp() {
        return mdp;
    }

    public void setMdp(ModeDePrise mdp) {
        this.mdp = mdp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", mdp=" + mdp +
                ", type=" + type +
                '}';
    }
}
