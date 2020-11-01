package com.PharmacyManagement;

import java.text.ParseException;
import java.util.Scanner;

public class Main {


    protected static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {

        int choix = menu();
        Achat a = new Achat();

        switch (choix){
            case 1:
                a.achatPartiel();
                break;
            case 2:
                a.achatSansOrd();
                break;
            case 3:
                a.CMDMedecin();
                break;
            case 4:
                quitter();
                break;
        }

    }
    static int menu() {
        int choix = 0;
        System.out.println();
        System.out.println();
        System.out.println("1 : client avec ordonnance");
        System.out.println("2 : client sans ordonnance");
        System.out.println("3 : medecin convontionné");
        System.out.println("4 : Quitter");
        while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
            choix = scanner.nextInt();
        }
        return choix;
    }
    static void quitter(){
        System.out.println("programme terminer!");
    }
}
