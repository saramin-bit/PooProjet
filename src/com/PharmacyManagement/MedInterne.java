package com.PharmacyManagement;

import java.util.ArrayList;

public class MedInterne extends Medicament {
    ArrayList<String> composition = new ArrayList<>();
    double dosage;

    public ArrayList<String> getComposition() {
        return composition;
    }

    public void setComposition(ArrayList<String> composition) {
        this.composition = composition;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }
    public MedInterne(String nom, double prix, ModeDePrise mdp, Type type, double dosage, ArrayList<String> composition){
        super();
        this.setNom(nom);
        this.setPrix(prix);
        this.setMdp(mdp);
        this.setType(type);
        this.composition=composition;
        this.dosage=dosage;
    }
    public double tauxRembInt(){
        return this.getPrix()-0.2*this.getPrix();
    }
}
