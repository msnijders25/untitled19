public class Adres {
    String postCode;
    String huisNr;
    String straat;

    Adres(String postCode, String huisNr, String straat){
        this.postCode = postCode;
        this.huisNr = huisNr;
        this.straat = straat;
    }

    public String printAdres(){
        return String.format("%n%s%n%s%n%s", postCode, huisNr, straat);
    }
}