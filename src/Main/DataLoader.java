package Main;
import Potion.Alcohol;
import Potion.Drink;
import Tobacoo.Cigar;
import Tobacoo.Cigarette;

import java.util.ArrayList;
public class DataLoader {
    public static ArrayList<Drink> loadDrinks() {
        Drink d1 = new Drink("Coca-cola",350,75,0.5);
        Drink d2 = new Drink("Tonic",300,50,0.5);
        Drink d3 = new Drink("Fanta",320,45,0.5);
        Drink d4 = new Drink("Pepsi",350,75,0.5);
        Drink d5 = new Drink("Water",300,100,0.5);
        Drink d6 = new Drink("Orange",500,15,0.4);
        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.add(d1);
        drinks.add(d2);
        drinks.add(d3);
        drinks.add(d4);
        drinks.add(d5);
        drinks.add(d6);
        return drinks;
    }
    public static ArrayList<Alcohol> loadAlcohols() {
        ArrayList<Alcohol> alcohols = new ArrayList<>();
        Alcohol a1 = new Alcohol("Kőbányai",295,100,0.5,4);
        Alcohol a2 = new Alcohol("Soproni",330,80,0.5,4.6);
        Alcohol a3 = new Alcohol("Heineken",350,50,0.5,4);
        Alcohol a4 = new Alcohol("Nyakas",2000,10,0.7,10.5);
        Alcohol a5 = new Alcohol("Bock",3500,20,0.7,11.0);
        Alcohol a6 = new Alcohol("Kevert",2500,20,0.5,30);
        Alcohol a7 = new Alcohol("Jameson",8800,62,0.7,36);
        Alcohol a8 = new Alcohol("Hubertus",7700,34,0.7,40);
        alcohols.add(a1);
        alcohols.add(a2);
        alcohols.add(a3);
        alcohols.add(a4);
        alcohols.add(a5);
        alcohols.add(a6);
        alcohols.add(a7);
        alcohols.add(a8);
        return alcohols;
    }
    public static ArrayList<Cigarette> loadCigarettes() {
        ArrayList<Cigarette> cigarettes = new ArrayList<>();
        Cigarette c1 = new Cigarette("Mallboro",2100,40);
        Cigarette c2 = new Cigarette("Multifilter",1900,50);
        Cigarette c3 = new Cigarette("Camel",2000,30);
        Cigarette c4 = new Cigarette("Heets",1850,75);
        cigarettes.add(c1);
        cigarettes.add(c2);
        cigarettes.add(c3);
        cigarettes.add(c4);
        return cigarettes;
    }
    public static ArrayList<Cigar> loadCigars() {
        ArrayList<Cigar> cigars = new ArrayList<>();
        Cigar ci1 = new Cigar("Acid",3000,5,"Tobacco");
        Cigar ci2 = new Cigar("Tatuaje",2800,8,"Tobacco");
        Cigar ci3 = new Cigar("Caldwell",3800,9,"Tobacco");
        Cigar ci4 = new Cigar("Avanti",5000,10,"Vanillia");
        cigars.add(ci1);
        cigars.add(ci2);
        cigars.add(ci3);
        cigars.add(ci4);
        return cigars;
    }
}
