import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    protected static OpgeslagenCategorien opgeslagenCategorien = new OpgeslagenCategorien();
    protected static OpgeslagenGebruikers opgeslagenGebruikers = new OpgeslagenGebruikers();
    protected static Gebruiker loggedGebruiker;
    protected static Menu welkomScherm = new WelkomScherm();
    protected static Menu aanmeldScherm = new AanmeldScherm();
    protected static Menu inlogScherm = new InlogScherm();
    protected static Menu mainMenu = new MainMenu();
    protected static Menu menuKiesLevensMiddel = new MenuKiesLevensMiddel();
    protected static Menu menuDeelLevensMiddel = new MenuDeelLevensMiddel();
    protected static Menu menuMand = new MenuMand();
    protected static Menu menuBestelling = new MenuBestelling();
    protected static Menu zieGeplaatsteProducten = new MenuZieGeplaatsteMiddelen();

    protected Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Menu> menus;

    public abstract void menu();

    public void printCategorien() {
        int i = 1;
        for (Categorie categorie : opgeslagenCategorien.getCategories()) {
            System.out.println(i++ + " " + categorie.getNaam());
        }
    }

    protected boolean validateInput(ArrayList array, int keuze) {
        if (keuze >= 0 && keuze < array.size() && array.get(keuze) != null) {
            return true;
        } else {
            System.out.println("Error: Incorrecte input");
            return false;
        }
    }
}

class WelkomScherm extends Menu {
    public void menu() {
        System.out.println("Welkom bij Overshare");
        System.out.println("1. inloggen");
        System.out.println("2. aanmelden");
        System.out.print("keuze: ");
        int keuze = scanner.nextInt();

        switch (keuze) {
            case 1:
                inlogScherm.menu();
                break;
            case 2:
                aanmeldScherm.menu();
                break;
            default:
                System.out.println("Error: Invalide keuze. Probeer nog eens");
                menu();
                break;
        }
    }
}

class InlogScherm extends Menu {
    public void menu() {
        System.out.println("Voer uw inloggegevens in:");
        System.out.print("Voer uw gebruikersnaam in: ");
        String gebruikersNaam = scanner.nextLine();
        System.out.print("Voer uw wachtwoord in: ");
        String wachtWoord = scanner.nextLine();

        if (opgeslagenGebruikers.getGebruiker(gebruikersNaam, wachtWoord) != null) {
            loggedGebruiker = opgeslagenGebruikers.getGebruiker(gebruikersNaam, wachtWoord);
            mainMenu.menu();
        } else {
            System.out.println("Error: Inloggegevens zijn ongeldig. Probeer het opnieuw.");
            welkomScherm.menu();
        }
    }
}

class AanmeldScherm extends Menu {
    public void menu() {
        Gebruiker nieuweGebruiker = opgeslagenGebruikers.maakNieuweGebruikerAan();
        System.out.println("Account van " + nieuweGebruiker.getGebruikersNaam() + " is aangemaakt");
        inlogScherm.menu();
    }
}

class MainMenu extends Menu {
    public void menu() {
        System.out.println("1. Kies een levensmiddel");
        System.out.println("2. Deel een levensmiddel");
        System.out.println("3. Zie mandje/plaats een bestelling");
        System.out.println("4. Zie bestelgeschiedenis");
        System.out.println("5. Zie uw gedeelde producten");
        System.out.println("6. Uitloggen");

        int keuze = scanner.nextInt();
        switch (keuze) {
            case 1:
                menuKiesLevensMiddel.menu();
                break;
            case 2:
                menuDeelLevensMiddel.menu();
                break;
            case 3:
                menuMand.menu();
                break;
            case 4:
                menuBestelling.menu();
                break;
            case 5:
                zieGeplaatsteProducten.menu();
                break;
            case 6:
                welkomScherm.menu();
                break;
        }
    }
}

class MenuKiesLevensMiddel extends Menu {
    public void menu() {
        printCategorien();
        System.out.print("Kies een categorie: ");
        int keuze = scanner.nextInt() - 1;

        if (validateInput(opgeslagenCategorien.getCategories(), keuze)) {
            Categorie gekozenCategorie = opgeslagenCategorien.getCategorie(keuze);
            gekozenCategorie.printLijstLevensMiddelenUit();
            System.out.print("Kies een levensmiddel: ");
            int keuzeLevensMiddel = scanner.nextInt() - 1;

            if (validateInput(gekozenCategorie.getLevensMiddelen(), keuzeLevensMiddel)) {
                loggedGebruiker.getMandje().voegAanMandjeToe(gekozenCategorie, keuzeLevensMiddel);
                System.out.println("U heeft gekozen voor: " + gekozenCategorie.getLevensMiddelen().get(keuzeLevensMiddel).getNaam());
                mainMenu.menu();
            }
        } else {
            System.out.println("Probeer het nog eens");
            menu();
        }
    }
}

class MenuDeelLevensMiddel extends Menu {
    public void menu() {
        printCategorien();
        System.out.print("Kies een categorie: ");
        int keuze = scanner.nextInt() - 1;

        if (validateInput(opgeslagenCategorien.getCategories(), keuze)) {
            Categorie gekozenCategorie = opgeslagenCategorien.getCategorie(keuze);
            gekozenCategorie.voegEenLevensMiddelToe(loggedGebruiker);
            mainMenu.menu();
        } else {
            System.out.println("Probeer het nog eens");
            menu();
        }
    }
}

class MenuMand extends Menu {
    public void menu() {
        loggedGebruiker.getMandje().printLijstLevensMiddelenUit();
        System.out.println("Kies welk product u wilt bestellen");
        int keuze = scanner.nextInt() - 1;

        if (validateInput(loggedGebruiker.getMandje().getLevensMiddelen(), keuze)) {
            Bestelling bestelling = new Bestelling(loggedGebruiker.getMandje().levensMiddelen.get(keuze));
            for (Categorie categorie : opgeslagenCategorien.getCategories()) {
                categorie.verwijderLevensMiddelen(loggedGebruiker.getMandje().levensMiddelen.get(keuze));
            }
            loggedGebruiker.getMandje().levensMiddelen.remove(keuze);
            loggedGebruiker.setBestellingen(bestelling);
            mainMenu.menu();
        } else {
            System.out.println("Probeer het nog eens");
            menu();
        }
    }
}

class MenuZieGeplaatsteMiddelen extends Menu {
    public void menu() {
        int i = 1;
        for (LevensMiddelen middel : loggedGebruiker.getGedeeldeLevensMiddelen()) {
            System.out.println(i++ + ". " + middel.getNaam());
        }

        System.out.println("Kies een optie:");
        int keuze = scanner.nextInt() - 1;
        loggedGebruiker.getGedeeldeLevensMiddelen().get(keuze);

        System.out.println("1. Voor inzage op product:");
        System.out.println("2. Als u het product wilt verwijderen");

        int keuze2 = scanner.nextInt();
        switch (keuze2) {
            case 1:
                loggedGebruiker.getGedeeldeLevensMiddelen().get(keuze).printInformatie();
                break;

            case 2:
                for (Categorie categorie : opgeslagenCategorien.getCategories()) {
                    categorie.verwijderLevensMiddelen(loggedGebruiker.getGedeeldeLevensMiddelen().get(keuze));
                }
                break;

            default:
                System.out.println("Verkeerde input probeer het nog eens:");
                menu();
                break;
        }
        mainMenu.menu();
    }
}

class MenuBestelling extends Menu {
    public void menu() {
        int i = 1;
        for (Bestelling bestelling : loggedGebruiker.bestellingen) {
            System.out.println(i + ". " + bestelling.levensMiddel.getNaam());
        }
        System.out.println("Kies een bestelling:");
        int keuze = scanner.nextInt() - 1;

        if (validateInput(loggedGebruiker.bestellingen, keuze)) {
            loggedGebruiker.bestellingen.get(keuze).bestellingShow();
            mainMenu.menu();
        }
    }
}
