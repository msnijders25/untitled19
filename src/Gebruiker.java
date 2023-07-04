import java.util.ArrayList;

public class Gebruiker {
    private String gebruikersNaam;
    private String wachtWoord;
    private Adres adres;

    private ArrayList<LevensMiddelen> gedeeldeLevensMiddelen = new ArrayList<>();

    ArrayList<Bestelling> bestellingen = new ArrayList<>();

     private Mandje mandje = new Mandje();
Gebruiker(String gebruikersNaam, String wachtWoord, Adres adres){
    this.gebruikersNaam = gebruikersNaam;
    this.wachtWoord = wachtWoord;
    this.adres = adres;

}

    public Gebruiker() {

    }
   public void addGedeeldeLevensMiddelen(LevensMiddelen levensMiddelen){
    gedeeldeLevensMiddelen.add(levensMiddelen);
   }

   public ArrayList<LevensMiddelen> getGedeeldeLevensMiddelen(){
    return gedeeldeLevensMiddelen;
   }
    public void setBestellingen(Bestelling bestelling){
    this.bestellingen.add(bestelling);
}
    public ArrayList<Bestelling> getBestellingen(){
        return bestellingen;
    }

public String getWachtWoord(){
    return wachtWoord;
}
public String getGebruikersNaam(){
    return gebruikersNaam;
}
    public void setMandje(Mandje mandje){
    this.mandje = mandje;
    }

    public Mandje getMandje() {
        return mandje;
    }
    public Adres getAdres(){
    return adres;
    }
}
