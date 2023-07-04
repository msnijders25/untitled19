import java.util.Scanner;

public class LevensMiddelen implements Overzicht {

   private  Categorie categorie;
    private String naam;
   private  Gebruiker gebruiker;
   private  Adres adres;

    LevensMiddelen(Categorie categorie, String naam, Gebruiker gebruiker){
        this.categorie = categorie;
        this.naam = naam;
        this.gebruiker = gebruiker;
    }

    public LevensMiddelen(Categorie categorieFruit) {
    }

    public LevensMiddelen() {

    }

    public String getNaam(){
        return naam;
    }

    public void setNaam(String naam){
        this.naam = naam;
    }

    public void setGebruiker(Gebruiker gebruiker){
        this.gebruiker = gebruiker;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }
    public void setNieuweAdres(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Straatnaam: " );
        String straat = scanner.nextLine();
        System.out.print("Huisnummer: ");
        String huisnr = scanner.nextLine();
        System.out.print("postcode: ");
        String postCode = scanner.nextLine();
        this.adres = new Adres(postCode, huisnr,straat);
    }
    public Adres getAdres(){
        return adres;
    }
    public void setAdres(Adres adres){
        this.adres = adres;
    }


    @Override
    public void printInformatie() {

    System.out.println("Naam: " + naam);
    System.out.println("OphaalLocatie: ");
    System.out.println("Straat: " + adres.straat + " " + adres.huisNr);
    System.out.println("Postcode: " + adres.postCode);






    }
}

class Bakerij extends  LevensMiddelen {

    Bakerij(Categorie categorie, String naam, Gebruiker gebruiker) {
        super(categorie, naam, gebruiker);
    }

    @Override
    public void printInformatie() {

    }
}

class HuishoudMiddelen extends  LevensMiddelen{

    HuishoudMiddelen(Categorie categorie, String naam, Gebruiker gebruiker) {
        super(categorie, naam, gebruiker);
    }

    public HuishoudMiddelen(Categorie categorieHuishoudMiddelen) {
        super(categorieHuishoudMiddelen);
    }

    @Override
    public void printInformatie() {

    }

}
class Slager extends  LevensMiddelen{

    Slager(Categorie categorie, String naam, Gebruiker gebruiker) {
        super(categorie, naam, gebruiker);
    }

    public Slager(Categorie categorieSlager) {
        super(categorieSlager);
    }

    @Override
    public void printInformatie() {

    }

}