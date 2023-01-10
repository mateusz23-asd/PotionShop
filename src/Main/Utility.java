package Main;
import java.util.ArrayList;
import Potion.Alcohol;
import Potion.Drink;
import Tobacoo.Cigarette;
import Tobacoo.Cigar;
import Customer.Customer;
public class Utility {
	private String escape;
	public void menuHeader() {
		System.out.println();
		System.out.println("------------------ Menu select ------------------");
		System.out.println("  Please write the exactly name to select a menu!");
		System.out.println();
		System.out.println("  [details] --- It will show you, your details.");
		System.out.println("     [list] --- It will show you the available drinks and ciggarettes.");
		System.out.println(" [shopping] --- You can buy things.");
		System.out.println("   [upload] --- You can upload your balance.");
		System.out.println("   [basket] --- Purchased items.");
		System.out.println("     [exit] --- Quit from the program.");
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	public void drinksHeader() {
		System.out.println();
		System.out.println("----------Drinks and Cigarette products----------");
		System.out.println("Refershers:");
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
	public void escapeInfo(int money, int itemCount) {
		this.escape = "Thank you for shopping, have a nice day!\nYour total spent: " + money + " Ft .\nAmount of items you purcashed: " + itemCount +".";
		
	}
	public void customerInfo(Customer a) {
		System.out.println();
		System.out.println("----------Customer details: -----");
		System.out.println(a);
		System.out.println("-------------------------------");
	}
	public void purcasheInfo() {
		System.out.println();
		System.out.println("What do you want to buy?");
		System.out.println("Write it down what you want to buy, exactly!");
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
		System.out.println("----- If the tranzaction faild    ----");
		System.out.println("----- Please check these details  ----");
		System.out.println("- The product is exists?;");
		System.out.println("- Is there enough amount of the products what you want to buy;");
		System.out.println("- You have enough money;");
		System.out.println("-------------------------------------------------------");
		System.out.println();
	}
	public void successfulPurchase() {
		System.out.println("//////////////////////////");
		System.out.println("///SUCCESSFUL PURCHASE!///");
		System.out.println("//////////////////////////");
	}
	public void shoppingMenu(){
		System.out.println("Write it down what you want to buy, exactly!");
		System.out.println("	---   [alcohol] --- ");
		System.out.println("	---    [drinks] --- ");
		System.out.println("	--- [cigarette] --- ");
		System.out.println("	---     [cigar] --- ");
		System.out.println("--------------------------------------------");
	}
	public String getEscape() {
		return escape;
	}
	public void setEscape(String escape) {
		this.escape = escape;
	}
}
