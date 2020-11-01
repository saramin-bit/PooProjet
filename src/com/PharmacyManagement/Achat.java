package com.PharmacyManagement;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Achat {
    ArrayList<ClientPermanent> clients = new ArrayList<>();
    ArrayList<MedicamentExterne> medicaments1 = new ArrayList<>();
    ArrayList<MedInterne> medicaments2 = new ArrayList<>();
    ArrayList<ProdParaPharma> produits = new ArrayList<>();


    String lireNomC(){
        System.out.println("Nom du Client :");
        return Main.scanner.nextLine();
    }
    String lirePrenomC(){
        System.out.println("prenom du client :");
        return Main.scanner.nextLine();
    }
    int lireAge(){
        System.out.println("Age du client :");
        return Main.scanner.nextInt();
    }
    boolean lireMaladichro(){
        System.out.println("est ce que le client a une maladie chronique ? [oui/non]");
        if(Main.scanner.nextLine().equalsIgnoreCase("oui")){
            return true;
        }else return false;
    }
    int lireNSS(){
        System.out.println("numero de securité sociale du client :");
        return Main.scanner.nextInt();
    }
    public Client lireClientLambda(){
        String nomC,prenomC;
        int age,nss;
        boolean mc;
        nomC=lireNomC();
        prenomC=lirePrenomC();
        age=lireAge();
        mc=lireMaladichro();
        nss=lireNSS();
        Client p = new Client(nomC,prenomC,age,nss,mc);
        return p;
    }
    String lireNomM(){
        System.out.println("Nom du medecin :");
        return Main.scanner.nextLine();
    }
    String lirePrenomM(){
        System.out.println("Prenom du medecin :");
        return Main.scanner.nextLine();
    }
    String lireSpec(){
        System.out.println("specialite du medecin :");
        return Main.scanner.nextLine();
    }
    String lireAdresse(){
        System.out.println("Adresse du medecin :");
        return Main.scanner.nextLine();
    }
    boolean lireConv(){
        System.out.println("est ce que c'est un medecin convontionne? [oui/non]");
        boolean test = Main.scanner.nextLine().equalsIgnoreCase("oui");
        if (test){
            return true;
        }else return false;
    }
    public Medecin lireMedecin(){
        String prenomM,nomM,specialite,adresse;
        boolean conv;
        nomM=lireNomM();
        prenomM=lirePrenomM();
        specialite=lireSpec();
        adresse=lireAdresse();
        conv = lireConv();
        Medecin m = new Medecin(nomM,prenomM,specialite,adresse,conv);
        return m;
    }

    int lireDuree(){
        System.out.println("quel est la duree du traitement ? ");
        return Main.scanner.nextInt();
    }
    public static Date lireDate(Scanner sc , String format) throws ParseException {
        return new SimpleDateFormat(format).parse(sc.nextLine());
    }

    ArrayList<MedPresc> lireMedPresc(){
        ArrayList<MedPresc> m = new ArrayList<>();
        System.out.println("voulez vous ajouter un medicament? [oui/non]");
        boolean arreter = false;
        int qte, duree;
        MedPresc medp = new MedPresc();
        do {
            if (Main.scanner.nextLine().equalsIgnoreCase("non")){
                arreter= true;
            }else {
                Medicament med = lireMedicament();
                qte = lireQteAcheter();
                duree= lireDuree();
                medp.setMedpresc(med);
                medp.setQteDemande(qte);
                medp.setDuree(duree);
                m.add(medp);
            }
        }while (!arreter);
        return m;
    }


    public Ordonnance avecOrd() throws ParseException {
        Ordonnance ord = new Ordonnance();
        Client c = lireClient();
        Scanner sc = null;
        if (c!=null){
            ord.client=c;
        }else {
            c = lireClientLambda();
            ord.client=c;
        }
        Medecin m = lireMedecin();
        ArrayList<MedPresc> med = lireMedPresc();
        String format = "dd/mm/y";
        Date dc =  lireDate(sc, format);

        ord.setInfoMed(m);
        ord.setMedicaments(med);
        ord.setDateConsult(dc);

        return ord;
    }
    public Client lireClient(){
        String nom;
        boolean trouve = false;
        Client c = null;

        System.out.println("Nom du client? ");
        nom = Main.scanner.nextLine();
        for(int i=0; (!trouve && i<clients.size());i++){
            if ((clients.get(i).getNom()).equals(nom)) {
                trouve = true;
                c = clients.get(i);
            }
        }
        return c;
    }
    public boolean perma(Client c){
        boolean trouve = false;
        for(int i=0;(!trouve && i< clients.size());i++){
            if (clients.get(i).equals(c.getNom())){
                trouve=true;
            }
        }
        return trouve;
    }
    // retourner medicament
    public Medicament lireMedicament(){
        String nom;
        boolean trouve = false;
        Medicament m = null;

        System.out.println("Nom du medicaments ? ");
       do {
           nom = Main.scanner.nextLine();
           for(int i=0;(!trouve && i<medicaments1.size());i++){
               if((medicaments1.get(i).getNom()).equals(nom)){
                   trouve = true;
                   m =(Medicament) medicaments1.get(i);
               }
           }
           if (!trouve){
               for(int i=0;(!trouve && i<medicaments2.size());i++){
                   if((medicaments2.get(i).getNom()).equals(nom)){
                       trouve = true;
                       m =(Medicament) medicaments2.get(i);
                   }
               }
               if (!trouve) System.out.println("Medicament inconnu, veuillez recommencer!");
           }
       }while (!trouve);
        return m;
    }
    // tester medicaments
    public boolean trouveMedicament(Medicament m){
        boolean trouve = false;
        boolean interne = false;

        for(int i=0;(!trouve && i<medicaments1.size());i++){
            if((medicaments1.get(i).getNom()).equals(m.getNom())){
                trouve = true;
                interne = false;
            }
        }
        if (!trouve){
            for(int i=0;(!trouve && i<medicaments2.size());i++){
                if((medicaments2.get(i).getNom()).equals(m.getNom())){
                    trouve = true;
                    interne= true;
                }
            }
        }
        return interne;
    }
    public double calculMontatntP(ProdParaPharma p, int qteAcheter){
        double montant = 0;
        montant += p.getPrix()*qteAcheter;
        return montant;
    }
    public double calculMontant(Medicament med, int qteAcheter){
        double montant=0;
        montant += med.getPrix()*qteAcheter;
        return montant;
    }


    public int lireQteAcheter(){
        System.out.println("entrer la quantite que vous voulez achetr!");
        return Main.scanner.nextInt();
    }

    public ProdParaPharma lireProduit(){
        ProdParaPharma p = null;
        boolean trouve = false;
        String nom;
        System.out.println("Nom du produit ?");
        nom = Main.scanner.nextLine();
        for (int i=0;(!trouve && i<produits.size());i++){
            if((produits.get(i).getNom()).equals(nom)){
                trouve = true;
                p = produits.get(i);
            }
        }
        return p;
    }
    public void CMDMedecin(){
        int qte = lireQteAcheter();
        Medecin m = lireMedecin();
        if (m.isConvontionné()) {
            System.out.println("voulez vous acheter un produits ");
            if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                ProdParaPharma p = lireProduit();
                if (p == null) {
                    System.out.println("voulez vous acheter un medicament : ");
                    if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                        Medicament med = lireMedicament();
                        if (med == null){
                            System.out.println("medicament indispo");
                        }else System.out.println(" commande faite ");
                    }else  System.out.println("OK BYE");
                }else System.out.println("Commande faite !");
            }else {

                System.out.println("voulez vous acheter un medicament : ");
                if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                    Medicament med = lireMedicament();
                    if (med == null){
                        System.out.println("medicament indispo");
                    }else System.out.println("commande faite");
                }else  System.out.println("OK BYE");
            }
        }else System.out.println("Medecin non convontionne ! pas de commande ");

    }
    //==============================================================================//
    public void achatSansOrd(){
        Client c = lireClient();
        if (c != null){
            ArrayList<Medicament> lMed = new ArrayList<>();
            Medicament m = lireMedicament();
            if (m != null){
                lMed.add(m);
                boolean arreter = false;
                System.out.println("voulez vous ajouter un medicament ? [oui/non]");
                do {
                    if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                        m= lireMedicament();
                        lMed.add(m);
                    }else arreter= true;
                }while (!arreter);
                for (Medicament m1 : lMed){
                    int qte = lireQteAcheter();
                    if (trouveMedicament(m1)){ //interne
                        System.out.println("Medicament necessite une ordonnance ");
                    }else {
                        //externe
                        MedicamentExterne m2 = (MedicamentExterne) m1;
                        if (m2.dispo(qte)){
                            if (c.getNss() != 0){
                                m2.tauxRembExt();
                                System.out.println("Montant : "+calculMontant(m2,qte));
                            } else System.out.println("medicament necessite une ordonnace!");

                        }else System.out.println("quantite non disponible !");

                    }
                }
            }
            ArrayList<ProdParaPharma> lProduits = new ArrayList<>();
            ProdParaPharma p=lireProduit();
            if (p != null){
                lProduits.add(p);
                boolean arreter = false;
                System.out.println("voulez vous ajouter un produits ? [oui/non]");
                do {
                    if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                        p=lireProduit();
                        lProduits.add(p);
                    }else arreter= true;
                }while (!arreter);
                for (ProdParaPharma i : lProduits){
                    int qte = lireQteAcheter();
                    if (i.conditionAchat(qte)){
                        System.out.println("Montant : "+calculMontatntP(p,qte));
                    }else System.out.println("quantite indisponible!");
                }
            }

        }
    }

    public void achatPartiel() throws ParseException {
        Ordonnance o = avecOrd();
        ArrayList<MedPresc> m = o.getMedicaments();
        for (MedPresc i : m){
            if (trouveMedicament(i.getMedpresc())){ // medicament interne
                if (o.getClient().getNss() == 0){
                    // pas de rembourssement
                    System.out.println("Achat fait avec succes !");
                    System.out.println("Montant : "+calculMontant(i.getMedpresc(),i.getQteDemande()));
                }else {
                    // avec remboursement
                    System.out.println("Achat fait avec succes!");
                    MedInterne m1 = (MedInterne) i.getMedpresc();
                    m1.tauxRembInt();
                    System.out.println("Montant : "+calculMontant(m1,i.getQteDemande()));
                }
            }else {
                // externe
                MedicamentExterne m1 = (MedicamentExterne) i.getMedpresc();
                if (m1.conditionAchat(i,i.getQteDemande())){
                    if (o.getClient().getNss()== 0){
                        // sans remboursement
                        System.out.println("Achat fait avec succes !");
                        System.out.println("Montant : "+calculMontant(m1,i.getQteDemande()));
                    }else {
                        // avec remboursement
                        m1.tauxRembExt();
                        System.out.println("Montant : "+calculMontant(m1,i.getQteDemande()));
                    }
                }else if (perma(o.getClient())){
                    System.out.println("voulez vous passer une commande ? [oui/non]");
                    if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                        AjouterCmdClient(m);
                    }else System.out.println("au revoir!");
                }else System.out.println("Desolee quantite indisponnible!");
            }
        }
    }





    ArrayList<Commande> listeDesCommandes = new ArrayList<>();
    void ajouterUneCommande(ArrayList<Commande> medCommander){
        listeDesCommandes.addAll(medCommander);
        System.out.println("La commande est ajoutée avec succés!");
        fournisseur();
    }
    void fournisseur(){
        System.out.println("commande envoyer au fournisseur !");
    }
    void AjouterCmdClient(ArrayList<MedPresc> med){
        if (med.size() != 0){
            System.out.println("passer une commande des meds non dispo? [oui/non]");
            if (Main.scanner.nextLine().equalsIgnoreCase("oui")){
                ArrayList<Commande> medCommande = new ArrayList<>();
                for (MedPresc i : med){
                    medCommande.addAll((Collection<? extends Commande>) new Commande(i.getMedpresc().getNom(), i.getQteDemande()));
                }
                ajouterUneCommande(medCommande);
            }
        }
    }


}
