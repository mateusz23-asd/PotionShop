package Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Potion.Alcohol;
import Potion.Drink;
import Tobacoo.Cigarette;
import Tobacoo.Cigar;
import Customer.Customer;
import Customer.Product;
public class Utility {
    public void menuHeader() {
        System.out.println();
        System.out.println("------------------ Menu select ------------------");
        System.out.println("  Please write the right number to select a menu!");
        System.out.println();
        System.out.println("     [0] --- Quit from the program.");
        System.out.println("     [1] --- A list of products.");
        System.out.println(" 	 [2] --- Shopping.");
        System.out.println("     [3] --- Basket.");
        System.out.println("	 [4] --- You can upload your balance.");
        System.out.println("  	 [5] --- It will show your details.");
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
    public void drinksHeader() {
        System.out.println();
        System.out.println("----------Drinks and Cigarette products----------");
        System.out.println("Refreshers:");
    }
    public void alcoholHeader() {
        System.out.println();
        System.out.println("Alcoholic drinks:");
    }
    public void cigaretteHeader() {
        System.out.println();
        System.out.println("Cigarettes:");
    }
    public void cigarHeader() {
        System.out.println();
        System.out.println("Cigars:");
    }
    public StringBuilder basketInfo(List<Product> basket) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Product> iterator = basket.iterator();
        int totalAmount = 0;
        while (iterator.hasNext()) {
            Product element = iterator.next();
            totalAmount += element.getPrice();
            stringBuilder.append(element.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\nTotal amount: " + totalAmount + "Ft");
        return stringBuilder;
    }
    public void customerInfo(Customer a) {
        System.out.println();
        System.out.println("----------Customer details: -----");
        System.out.println(a);
        System.out.println("-------------------------------");
    }
    public void purchaseInfo() {
        System.out.println();
        System.out.println("What do you want to buy?");
        System.out.println("Write it down exactly!");
    }
    public void drinkList(ArrayList<Drink> a) {
        System.out.println();
        for (Drink drink : a) {
            System.out.println(drink.toString());
        }
    }
    public void alcoholList(ArrayList<Alcohol> a) {
        System.out.println();
        for (Alcohol alcohol : a) {
            System.out.println(alcohol.toString());
        }
    }
    public void cigaretteList(ArrayList<Cigarette> a) {
        System.out.println();
        for (Cigarette cigarette : a) {
            System.out.println(cigarette.toString());
        }
    }
    public void cigarList(ArrayList<Cigar> a) {
        System.out.println();
        for (Cigar cigar : a) {
            System.out.println(cigar.toString());
        }
    }
    public void transactionalError() {
        System.out.println();
        System.out.println("|----------------------------------------------------------------------------|");
        System.out.println("|						 If the transaction failed    						 |");
        System.out.println("|						 Please check these details  						 |");
        System.out.println("|-You have entered the product name incorrectly or there is no such product  |");
        System.out.println("|-Is there enough quantity of the product?									 |");
        System.out.println("|-You don't have enough money to buy the product							 |");
        System.out.println("|--------------------------------------------------------------------------- |");
        System.out.println();
    }
    public void successfulPurchase() {
        System.out.println("		//////////////////////////");
        System.out.println("		///SUCCESSFUL PURCHASE!///");
        System.out.println("		//////////////////////////");
    }
    public void failedPurchase() {
        System.out.println("						 |----------------------|");
        System.out.println("						 |   FAILED PURCHASE!   |");
        System.out.println("						 |----------------------|");
    }
    public void shoppingMenu() {
        System.out.println("  Please write the right number to select a menu!");
        System.out.println();
        System.out.println("       [0] --- Quit from this menu");
        System.out.println("	   [1] --- Refreshers");
        System.out.println("	   [2] --- Alcoholic drinks ");
        System.out.println("	   [3] --- Cigarettes");
        System.out.println("       [4] --- Cigars");
        System.out.println();
        System.out.println("--------------------------------------------");
    }
}
