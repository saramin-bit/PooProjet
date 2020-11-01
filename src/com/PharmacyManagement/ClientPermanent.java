package com.PharmacyManagement;

import java.util.ArrayList;

public class ClientPermanent extends Client {
        ArrayList<Medicament> med = new ArrayList<>();

    public ClientPermanent(String nom, String prenom, int age, int nss, boolean mc, ArrayList<Medicament> med) {
        super(nom, prenom, age, nss, mc);
        this.med=med;
    }

    public ArrayList<Medicament> getMed() {
        return med;
    }

    public void setMed(ArrayList<Medicament> med) {
        this.med = med;
    }
}
