package com.PharmacyManagement;

import java.time.LocalDate;
import java.util.Date;

public class MedicamentExterne extends Medicament {
    private String nom_firme;
    private int qte;
    int numLot;
    private Date dateExp;

    public String getNom_firme() {
        return nom_firme;
    }

    public int getQte() {
        return qte;
    }

    public int getNumLot() {
        return numLot;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setNom_firme(String nom_firme) {
        this.nom_firme = nom_firme;
    }

    public void setNumLot(int numLot) {
        this.numLot = numLot;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    public MedicamentExterne(String nom, double prix, ModeDePrise mdp, Type type, String nom_firme, int qte, int numLot, Date dateExp){
        super();
        this.setNom(nom);
        this.setPrix(prix);
        this.setMdp(mdp);
        this.setType(type);
        this.setNom_firme(nom_firme);
        this.setQte(qte);
        this.setNumLot(numLot);
        this.setDateExp(dateExp);
    }
    public double tauxRembExt(){
        return this.getPrix()-0.1*this.getPrix();
    }
    public boolean dispo(int qteVoulu){
        if(this.getQte() > qteVoulu){
            return true;
        }else return false;
    }
    public void mAJStock(int qteAcheter){
        qte -= qteAcheter;
    }
    public void alimenterStock(){
        System.out.println("demander une commande au fournisseur!");
    }
    public boolean duree(MedPresc med){
        if (LocalDate.now().plusDays(med.getDuree()+1).isAfter(LocalDate.parse((CharSequence)this.getDateExp()))){
            return true;
        }else return false;
    }
    public boolean conditionAchat(MedPresc med, int qte){
        if (this.dispo(qte) && this.duree(med)){
            return true;
        }else return false;
    }
}
