package com.PharmacyManagement;

public class ProdParaPharma {
    private String nom;
    private double prix;
    private int qte;

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

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    public void MAJStock(int QteAcheter){
        qte -= QteAcheter;
    }
    public boolean conditionAchat(int qte){
        if (this.getQte()<qte){
            return true;
        }else return false;
    }
}
