package com.PharmacyManagement;

public class Commande {
    private String nom;
    private int quantite;

    public Commande(String nom, int quantite){
        this.nom=nom;
        this.quantite= quantite;
    }
    public Commande(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void affichage (){
        System.out.println("Produits ["+getNom()+"] avec quantite de ["+getQuantite()+"]");
    }
}
