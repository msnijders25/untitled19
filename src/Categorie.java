import java.util.ArrayList;
import java.util.Scanner;

public class Categorie implements printLijstLevensMiddelenUit {
    private String naam;
    private ArrayList<LevensMiddelen> levensMiddelen;

    Categorie(String naam, ArrayList<LevensMiddelen> levensMiddelen) {
        this.naam = naam;
        this.levensMiddelen = levensMiddelen;
    }

    public String getNaam() {
        return naam;
    }


    public ArrayList<LevensMiddelen> getLevensMiddelen() {
        return levensMiddelen;

    }

    public void voegLevensMiddelToe(LevensMiddelen levensMiddel) {
        levensMiddelen.add(levensMiddel);
    }

    public void verwijderLevensMiddelen(LevensMiddelen levensMiddeltje){
        for(int i = 0 ; i < levensMiddelen.size(); i++ ){
            if(levensMiddeltje == levensMiddelen.get(i)){
                levensMiddelen.remove(i);
            }
        }
    }
    @Override
    public void printLijstLevensMiddelenUit() {
        int i = 1;
        for (LevensMiddelen middel : levensMiddelen) {
            System.out.println(i++ + " " + middel.getNaam());
        }
    }
    public void voegEenLevensMiddelToe(Gebruiker gebruiker) {
        LevensMiddelen nieuweLevensMiddel = new LevensMiddelen();
        gebruiker.addGedeeldeLevensMiddelen(nieuweLevensMiddel);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is de naam van dit levensmiddel:");

        String naam = scanner.nextLine();
        nieuweLevensMiddel.setNaam(naam);
        System.out.println("Wat is de ophaal locatie?");
        System.out.println("1. Thuis Adres: " + gebruiker.getAdres().printAdres());
        System.out.println("2. Nieuwe Adres");
        int keuze = scanner.nextInt();
        switch(keuze){
            case 1: nieuweLevensMiddel.setAdres(gebruiker.getAdres());
            break;
            case 2: nieuweLevensMiddel.setNieuweAdres();
            break;
            default: System.out.println("Verkeerde input probeer het nog eens");
            voegEenLevensMiddelToe(gebruiker);

        }



        nieuweLevensMiddel.setGebruiker(gebruiker);
        voegLevensMiddelToe(nieuweLevensMiddel);
    }


    public LevensMiddelen getLevensMiddel (int index) {
           return levensMiddelen.get(index);
           }


}
