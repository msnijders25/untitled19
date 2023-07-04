import java.util.ArrayList;

public class OpgeslagenCategorien {
    static private ArrayList<Categorie> categories = new ArrayList<>();
   static  private ArrayList<LevensMiddelen> slager = new ArrayList<>();
   static private ArrayList<LevensMiddelen> huisHoudmiddelen = new ArrayList<>();
    static private ArrayList<LevensMiddelen> bakkerij = new ArrayList<>();



    OpgeslagenCategorien(){
        categories.add(new Categorie("Slager", slager)) ;
        categories.add(new Categorie("HuishoudMiddelen", huisHoudmiddelen));
        categories.add(new Categorie("Bakkerij", bakkerij));

    }

    public void printCategorienUit(){
        int i = 0;
        for(Categorie categorie: categories){
            System.out.println(i++ + " " + categorie.getNaam());
        }
    }
    public void setCategories(ArrayList<Categorie> categories){



    }
    public Categorie getCategorie(int index) {
        return  categories.get(index);}
    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    public ArrayList<LevensMiddelen> getSlager(){
        return slager;
   }
    public ArrayList<LevensMiddelen> getBakker(){
        return bakkerij;
    }
    public ArrayList<LevensMiddelen> getHuisHoudmiddelen(){
        return huisHoudmiddelen;
    }


}

