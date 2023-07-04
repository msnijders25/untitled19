import java.util.Scanner;

public class Bestelling {

    LevensMiddelen levensMiddel;

    Bestelling(LevensMiddelen levensMiddelen){
        this.levensMiddel = levensMiddelen;
    }
    public void bestellingShow(){
        levensMiddel.printInformatie();
    }

}
