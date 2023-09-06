package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Potion.Alcohol;
import Potion.Drink;
import Tobacoo.Cigarette;
import Tobacoo.Cigar;
import Customer.Customer;
import Customer.Product;
public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final String SAMPLE_FOR_NAME = "^[a-zA-ZaáeéiíoóöõuúüûAÁEÉIÍOÓÖÕUÚÜÛ\\s*]+$";
    public static void main(String[] args) {
        ArrayList<Drink> drinks = DataLoader.loadDrinks();
        ArrayList<Alcohol> alcohol = DataLoader.loadAlcohols();
        ArrayList<Cigarette> cigarette = DataLoader.loadCigarettes();
        ArrayList<Cigar> cigar = DataLoader.loadCigars();
        //varies initialization
        Utility utility = new Utility();
        boolean mainMenuExit = false;
        boolean nestedMenuExit = false;
        Customer customer = new Customer(scanCustomerName(),scanCustomerAge(),scanCustomerMoney());
        System.out.println("----- National drink and cigarette shop -----");
        do {
            utility.menuHeader();
            try {
                int menu = sc.nextInt();
                switch (menu) {
                    default:
                        System.out.println("Wrong menu selected, choose again!");
                        break;
                    case 0:
                        mainMenuExit = true;
                        break;
                    case 5:
                        utility.customerInfo(customer);
                        break;
                    case 1:
                        printList(utility,drinks,alcohol,cigarette,cigar);
                        break;
                    case 4:
                        upload(customer);
                        break;
                    case 3:
                        System.out.println(utility.basketInfo(customer.getBasket()));
                        break;
                    case 2:
                        do {
                            utility.shoppingMenu();
                            try {
                                int choose = sc.nextInt();
                                switch (choose) {
                                    default:
                                        System.out.println("Wrong item selected! Try again the shopping!");
                                        System.out.println();
                                        break;
                                    case 0:
                                        nestedMenuExit = true;
                                        break;
                                    case 2:
                                        if (customer.isAdult()) {
                                            if (calculateAlcohol(alcohol,customer,utility)) {
                                                utility.successfulPurchase();
                                            } else {
                                                utility.failedPurchase();
                                                utility.transactionalError();
                                            }
                                            nestedMenuExit = true;
                                        } else {
                                            System.out.println("You are not an adult person, you can't buy alcoholic drinks!");
                                        }

                                    case 1:
                                        if (calculateDrink(drinks,customer,utility)) {
                                            utility.successfulPurchase();
                                        } else {
                                            utility.failedPurchase();
                                            utility.transactionalError();
                                        }
                                        nestedMenuExit = true;

                                    case 3:
                                        if (customer.isAdult()) {
                                            if (calculateCigarette(cigarette,customer,utility)) {
                                                utility.successfulPurchase();
                                            } else {
                                                utility.failedPurchase();
                                                utility.transactionalError();
                                            }
                                            nestedMenuExit = true;
                                        } else {
                                            System.out.println("You are not an adult person, you can't buy cigarettes!");
                                        }

                                    case 4:
                                        if (customer.isAdult()) {
                                            if (calculateCigar(cigar,customer,utility)) {
                                                utility.successfulPurchase();
                                            } else {
                                                utility.failedPurchase();
                                                utility.transactionalError();
                                            }
                                            nestedMenuExit = true;
                                        } else {
                                            System.out.println("You are not an adult person, you can't buy cigars!");
                                        }

                                }
                            } catch (Exception e) {
                                System.out.println("Wrong input, try again!");
                                System.out.println();
                                sc.next();
                            }
                        } while (!nestedMenuExit);
                }
            } catch (Exception e) {
                System.out.println("Wrong input, try again!");
                sc.next();
            }
        } while (!mainMenuExit);
        if (customer.getBasket().size() != 0) {
            System.out.println("Thank you for shopping with us.");
            System.out.println();
            System.out.println("Your purchased items:");
            System.out.println(utility.basketInfo(customer.getBasket()));
        } else System.out.println("You didn't buy anything. Bye! We hope you will came back soon!");
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
    private static int scanCustomerAge() {
        int age = 0;
        boolean validAge = false;
        do {
            System.out.println("Please give your age:");
            age = sc.nextInt();
            if (age >= 10 && age <= 100) {
                validAge = true;
            } else {
                System.out.println(
                        "Wrong age! You should above 10years to buy something in the shop (and under 100 years) and you can't give alphabet characters!");
            }
        } while (!validAge);
        return age;
    }
    private static double scanCustomerMoney() {
        int money = 0;
        boolean validMoney = false;
        do {
            System.out.println("How much money you have:");
            money = sc.nextInt();
            if (money >= 500 && money <= 100000) {
                validMoney = true;
            } else {
                System.out.println("Wrong money amount! Minimum 500, maximum: 100000 Ft and you can't give alphabet characters!");
            }
        } while (!validMoney);
        return money;
    }
    private static void upload(Customer customer) {
        System.out.println("How much money you want to upload?");
        int upload = sc.nextInt();
        if (upload >= 500 && (customer.getMoney() + upload) <= 100000) {
            customer.setMoney(customer.getMoney() + upload);
            System.out.println("Successful upload!");
        } else {
            System.out.println("Upload is failed! Minimum money to upload is 500 ft and your balance can't above 100000 Ft after the upload!");
        }
    }
    private static void printList(Utility u,ArrayList<Drink> drinks,ArrayList<Alcohol> alcohol,ArrayList<Cigarette> cigarette,ArrayList<Cigar> cigar) {
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
    private static boolean calculateAlcohol(ArrayList<Alcohol> alcohols,Customer customer,Utility u) {
        boolean isCanBuy = false;
        u.alcoholList(alcohols);
        u.purchaseInfo();
        String alcoholName = sc.next();
        System.out.println("How many items do you want to buy?");
        int piece = sc.nextInt();
        for (Alcohol alcohol : alcohols) {
            if (alcohol.getName().toLowerCase().equals(alcoholName.toLowerCase())) {
                int priceAmount = (alcohol.getPrice() * piece);
                int isEnough = (alcohol.getPiece() - piece);
                if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
                    alcohol.setPiece(alcohol.getPiece() - piece);
                    customer.setMoney(customer.getMoney() - (alcohol.getPrice() * piece));
                    customer.addProduct(new Product(alcohol.getName(),alcohol.getPrice(),piece,alcohol.getPrice()));
                    isCanBuy = true;
                }
            }
        }
        return isCanBuy;
    }
    private static boolean calculateDrink(ArrayList<Drink> drinks,Customer customer,Utility u) {
        boolean isCanBuy = false;
        u.drinkList(drinks);
        u.purchaseInfo();
        String drinkName = sc.next();
        System.out.println("How many items do you want to buy?");
        int piece = sc.nextInt();
        for (Drink drink : drinks) {
            if (drink.getName().toLowerCase().equals(drinkName.toLowerCase())) {
                int priceAmount = (drink.getPrice() * piece);
                int isEnough = (drink.getPiece() - piece);
                if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
                    drink.setPiece(drink.getPiece() - piece);
                    customer.setMoney(customer.getMoney() - (drink.getPrice() * piece));
                    customer.addProduct(new Product(drink.getName(),drink.getPrice(),piece,drink.getPrice()));
                    isCanBuy = true;
                }
            }
        }
        return isCanBuy;
    }
    private static boolean calculateCigarette(ArrayList<Cigarette> cigarettes,Customer customer,Utility u) {
        boolean isCanBuy = false;
        u.cigaretteList(cigarettes);
        u.purchaseInfo();
        String cigaretteName = sc.next();
        System.out.println("How many items do you want to buy?");
        int piece1 = sc.nextInt();
        for (Cigarette cigarette : cigarettes) {
            if (cigarette.getName().toLowerCase().equals(cigaretteName.toLowerCase())) {
                int priceAmount = (cigarette.getPrice() * piece1);
                int isEnough = (cigarette.getPiece() - piece1);
                if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
                    cigarette.setPiece(cigarette.getPiece() - piece1);
                    customer.setMoney(customer.getMoney() - (cigarette.getPrice() * piece1));
                    customer.addProduct(new Product(cigarette.getName(),cigarette.getPrice(),piece1,cigarette.getPrice()));
                    isCanBuy = true;
                }
            }
        }
        return isCanBuy;
    }
    private static boolean calculateCigar(ArrayList<Cigar> cigars,Customer customer,Utility u) {
        boolean isCanBuy = false;
        u.cigarList(cigars);
        u.purchaseInfo();
        String cigarName = sc.next();
        System.out.println("How many items do you want to buy?");
        int piece1 = sc.nextInt();
        for (Cigar cigar : cigars) {
            if (cigar.getName().toLowerCase().equals(cigarName.toLowerCase())) {
                int priceAmount = (cigar.getPrice() * piece1);
                int isEnough = (cigar.getPiece() - piece1);
                if (isEnough >= 0 && (customer.getMoney() - priceAmount) >= 0) {
                    cigar.setPiece(cigar.getPiece() - piece1);
                    customer.setMoney(customer.getMoney() - (cigar.getPrice() * piece1));
                    customer.addProduct(new Product(cigar.getName(),cigar.getPrice(),piece1,cigar.getPrice()));
                    isCanBuy = true;
                }
            }
        }
        return isCanBuy;
    }
}
