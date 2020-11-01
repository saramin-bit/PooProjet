package com.PharmacyManagement;

import java.util.ArrayList;
import java.util.Date;

public class Ordonnance {
    Client client;
    Medecin infoMed;
    ArrayList<MedPresc> medicaments = new ArrayList<>();
    private Date dateConsult;
    public Ordonnance(Client client, Medecin infoMed, ArrayList<MedPresc> medicaments, Date dateConsult){
        this.client= client;
        this.infoMed= infoMed;
        this.medicaments=medicaments;
        this.dateConsult= dateConsult;
    }

    public Ordonnance() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Medecin getInfoMed() {
        return infoMed;
    }

    public void setInfoMed(Medecin infoMed) {
        this.infoMed = infoMed;
    }

    public Date getDateConsult() {
        return dateConsult;
    }

    public void setDateConsult(Date dateConsult) {
        this.dateConsult = dateConsult;
    }

    public ArrayList<MedPresc> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(ArrayList<MedPresc> medicaments) {
        this.medicaments = medicaments;
    }
}
