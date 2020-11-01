package com.PharmacyManagement;

import java.time.LocalDate;

public class MedPresc {
    private Medicament medpresc;
    private int qteDemande;
    int duree;

    public Medicament getMedpresc() {
        return medpresc;
    }

    public void setMedpresc(Medicament medpresc) {
        this.medpresc = medpresc;
    }

    public int getQteDemande() {
        return qteDemande;
    }

    public void setQteDemande(int qteDemande) {
        this.qteDemande = qteDemande;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }


}
