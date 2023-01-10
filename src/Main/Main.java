package Main;
import java.util.ArrayList;
import java.util.Scanner;
import Potion.Alcohol;
import Potion.Drink;
import Tobacoo.Cigarette;
import Tobacoo.Cigar;
import Customer.Customer;
public class Main {
	public static final Scanner sc = new Scanner(System.in);
	public static final String SAMPLE_FOR_NAME = "^[a-zA-ZaáeéiíoóöõuúüûAÁEÉIÍOÓÖÕUÚÜÛ\\s*]+$";
	public static final String SAMPLE_FOR_AGE = "^([1-8][0-9]|9[0-9]|100)+$";
	public static final String SAMPLE_FOR_MONEY = "^([5-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-8][0-9]{4}|9[0-8][0-9]{3}|99[0-8][0-9]{2}|999[0-8][0-9]|9999[0-9]|100000)+$";
	public static void main(String[] args) {
		Drink d1 = new Drink("Coca-cola", 350, 75, 0.5);
		Drink d2 = new Drink("Tonic", 300, 50, 0.5);
		Drink d3 = new Drink("Fanta", 320, 45, 0.5);
		Drink d4 = new Drink("Pepsi", 350, 75, 0.5);
		Drink d5 = new Drink("Water", 3000, 100, 0.5);
		Drink d6 = new Drink("Orange", 500, 15, 0.4);
		
		Alcohol a1 = new Alcohol("Kõbányai", 295, 100, 0.5, 4);
		Alcohol a2 = new Alcohol("Soproni", 330, 80, 0.5, 4.6);
		Alcohol a3 = new Alcohol("Heineken", 350, 50, 0.5, 4);
		Alcohol a4 = new Alcohol("Kevert", 2500, 20, 0.5, 30);
		Alcohol a5 = new Alcohol("Jameson", 8800, 62, 0.7, 36);
		Alcohol a6 = new Alcohol("Jägermeister", 7700, 34, 0.7, 40);
		
		ArrayList<Drink> drinks = new ArrayList<Drink>();	
		
		drinks.add(d1);
		drinks.add(d2);
		drinks.add(d3);
		drinks.add(d4);
		drinks.add(d5);
		drinks.add(d6);
		
		ArrayList<Alcohol> alcohol = new ArrayList<>();
		
		alcohol.add(a1);
		alcohol.add(a2);
		alcohol.add(a3);
		alcohol.add(a4);
		alcohol.add(a5);
		alcohol.add(a6);

		Cigarette c1 = new Cigarette("Mallboro", 2100, 40);
		Cigarette c2 = new Cigarette("Multifilter", 1900, 50);
		Cigarette c3 = new Cigarette("Camel", 2000, 30);
		Cigarette c4 = new Cigarette("Philip Morris", 2050, 75);
		
		Cigar ci1 = new Cigar("Acid", 3000, 5, "Tobacco");
		Cigar ci2 = new Cigar("Tatuaje", 2800, 8, "Tobacco");
		Cigar ci3 = new Cigar("Caldwell", 3800, 9, "Tobacco");
		Cigar ci4 = new Cigar("Avanti", 5000, 10, "Vanillia");
		
		ArrayList<Cigarette> cigarette = new ArrayList<>();
		
		cigarette.add(c1);
		cigarette.add(c2);
		cigarette.add(c3);
		cigarette.add(c4);
		
		ArrayList<Cigar> cigar = new ArrayList<>();
		
		cigar.add(ci1);
		cigar.add(ci2);
		cigar.add(ci3);
		cigar.add(ci4);
		//varies initialization
		Utility u = new Utility();
		boolean exit = false;
		int sumPiece = 0;
		int income = 0;
		Customer customer = new Customer(scanCustomerName(), scanCustomerAge(), scanCustomerMoney());
		System.out.println("----- National drink and cigarette shop -----");
		do {
			u.menuHeader();
			String menu = sc.next();
			try {
				switch (menu) {
				default:
					System.out.println("Wrong menu selected, choose again!");
					break;
				case "exit":
					exit = true;
					break;
				case "details":
					u.customerInfo(customer);
					break;
				case "list":
					printList(u,drinks,alcohol,cigarette,cigar);
					break;
				case "upload":
					upload(customer);
					break;
				case "basket":
					System.out.println(customer.getPruchasedThings());
					break;
				case "shopping":
					u.shoppingMenu();
					String choose = sc.next();
					switch (choose) {
					default:
						System.out.println("Wrong item selected! Try again the shopping!");
						break;
					case "alcohol":
						if(customer.isAdult()) {
							calculateAlcohol(alcohol, customer, income, sumPiece, u);
							u.transactionalError();
						} else {
							System.out.println("You are not an adult person, you can't buy alcoholic drinks!");
						}
						break;
						case "drinks":
						calculateDrink(drinks,customer,income,sumPiece,u);
						u.transactionalError();
						break;
					case "cigarette":
						if(customer.isAdult()) {
							calculateCigarette(cigarette,customer,income,sumPiece,u);
							u.transactionalError();
							break;
						} else {
							System.out.println("You are not an adult person, you can't buy cigarettes!");
							break;
						}
					case "cigar":
						if (customer.isAdult()) {
							calculateCigar(cigar,customer,income,sumPiece,u);
							u.transactionalError();
							break;
						} else {
							System.out.println("You are not an adult person, you can't buy cigars!");
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Wrong input, try again!");
				sc.next();
			}
		} while (!exit);
		if(u.getEscape() == null) {
			System.out.println("You didn't buy anything. Bye! We hope you will came back soon!");
		}else System.out.println(u.getEscape());;
		sc.close();
	}
	private static String scanCustomerName() {
		boolean validName = false;
		String name;
		do {
			System.out.println("Please give your name:");
			name = sc.nextLine();
			if (name.length() > 2 && name.length() <= 30 && name.matches(SAMPLE_FOR_NAME)) {
				validName = true;
			} else {
				System.out.println(
						"Wrong name, try again! (minimum 3, maximum 30 character and you couldn't use numbers!)");
			}
		} while (!validName);
		return name;
	}
	private static int scanCustomerAge(){
		String age;
		boolean validAge = false;
		do {
			System.out.println("Please give your age:");
			age = sc.nextLine();
			if (age.matches(SAMPLE_FOR_AGE)) {
				validAge = true;
			} else {
				System.out.println(
						"Wrong age! You should above 10years to buy something in the shop (and under 100 years) and you can't give alphabet caharacters!");
			}
		} while (!validAge);
		return Integer.parseInt(age);
	}
	private static double scanCustomerMoney(){
		String money;
		boolean validMoney = false;
		do {
			System.out.println("How much money you have:");
			money = sc.nextLine();
			if (money.matches(SAMPLE_FOR_MONEY)) {
				validMoney = true;
			} else {
				System.out.println("Wrong money amount! Minimum 500, maximum: 100000 Ft and you can't give alphabet characters!");
			}
		} while (!validMoney);
		return Double.parseDouble(money);
	}
	private static void upload(Customer customer){
		System.out.println("How much money you want to upload?");
		int upload = sc.nextInt();
		if (upload >= 500 && (customer.getMoney() + upload) <= 100000) {
			customer.setMoney(customer.getMoney() + upload);
			System.out.println("Successful upload!");
		} else {
			System.out.println("Upload is faild! Minimum money to upload is 500 ft and your balance can't above 100000 Ft after the upload!");
		}
	}
	private static void printList(Utility u, ArrayList<Drink> drinks, ArrayList<Alcohol> alcohol, ArrayList<Cigarette> cigarette, ArrayList<Cigar> cigar) {
		u.drinksHeader();
		u.drinkList(drinks);
		u.alcoholHeader();
		u.alcoholList(alcohol);
		u.cigaretteHeader();
		u.cigaretteList(cigarette);
		u.cigarHeader();
		u.cigarList(cigar);
		System.out.println("------------------------------------------------");
	}
	private static void calculateAlcohol(ArrayList<Alcohol> alcohol, Customer customer, int income, int SumPiece, Utility u) {
		u.alcoholList(alcohol);
		u.purcasheInfo();
		String alcoholName = sc.next();
		System.out.println("How many items you want to buy?");
		int piece = sc.nextInt();
		for (Alcohol a : alcohol) {
			if (a.getName().contains(alcoholName)) {
				int priceAmount = (a.getPrice() * piece);
				int isEnough = (a.getPiece() - piece);
				if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
					a.setPiece(a.getPiece() - piece);
					customer.setMoney(customer.getMoney() - (a.getPrice() * piece));
					income += (a.getPrice() * piece);
					SumPiece += piece;
					u.escapeInfo(income, SumPiece);
					customer.purcashedThings(piece, a.getName(), priceAmount, "alcohol");
					u.successfulPurchase();
					break;
				}
			}
		}
	}
	private static void calculateDrink(ArrayList<Drink> drinks, Customer customer, int income, int sumPiece, Utility u) {
		u.drinkList(drinks);
		u.purcasheInfo();
		String drink = sc.next();
		System.out.println("How many items you want to buy?");
		int piece = sc.nextInt();
		for (Drink d : drinks) {
			if (d.getName().toLowerCase().contains(drink.toLowerCase())) {
				int priceAmount = (d.getPrice() * piece);
				int isEnough = (d.getPiece() - piece);
				if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
					d.setPiece(d.getPiece() - piece);
					customer.setMoney(customer.getMoney() - (d.getPrice() * piece));
					income += (d.getPrice() * piece);
					sumPiece += piece;
					u.escapeInfo(income, sumPiece);
					customer.purcashedThings(piece, d.getName(), priceAmount, "drink");
					u.successfulPurchase();
					break;
				}
			}
		}
	}
	private static void calculateCigarette(ArrayList<Cigarette> cigarette, Customer customer, int income, int sumPiece, Utility u) {
		u.cigaretteList(cigarette);
		u.purcasheInfo();
		String cigaretteName = sc.next();
		System.out.println("How many items you want to buy?");
		int piece1 = sc.nextInt();
		for (Cigarette c : cigarette) {
			if (c.getName().toLowerCase().contains(cigaretteName.toLowerCase())) {
				int priceAmount = (c.getPrice() * piece1);
				int isEnough = (c.getPiece() - piece1);
				if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
					c.setPiece(c.getPiece() - piece1);
					customer.setMoney(customer.getMoney() - (c.getPrice() * piece1));
					income += (c.getPrice() * piece1);
					sumPiece += piece1;
					u.escapeInfo(income, sumPiece);
					customer.purcashedThings(piece1, c.getName(), priceAmount, "cigarette");
					u.successfulPurchase();
					break;
				}
			}
		}
	}
	private static void calculateCigar(ArrayList<Cigar> cigar, Customer customer, int income, int sumPiece, Utility u) {
		u.cigarList(cigar);
		u.purcasheInfo();
		String cigarName = sc.next();
		System.out.println("How many items you want to buy?");
		int piece1 = sc.nextInt();
		for (Cigar c : cigar) {
			if (c.getName().toLowerCase().contains(cigarName.toLowerCase())) {
				int priceAmount = (c.getPrice() * piece1);
				int isEnough = (c.getPiece() - piece1);
				if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
					c.setPiece(c.getPiece() - piece1);
					customer.setMoney(customer.getMoney() - (c.getPrice() * piece1));
					income += (c.getPrice() * piece1);
					sumPiece += piece1;
					u.escapeInfo(income, sumPiece);
					customer.purcashedThings(piece1, c.getName(), priceAmount, "cigar");
					u.successfulPurchase();
					break;
				}
			}
		}
	}
}
