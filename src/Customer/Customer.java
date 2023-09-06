package Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Customer {
    private String name;
    private int age;
    private double money;
    private boolean isAdult;
    private List<Product> basket;
    public Customer(String name,int age,double money) {
        super();
        this.name = name;
        this.age = age;
        this.money = money;
        this.basket = new ArrayList<>();
        if (age < 18 && age > 0) {
            isAdult = false;
        } else {
            isAdult = true;
        }
    }
    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public boolean isAdult() {
        return isAdult;
    }
    public List<Product> getBasket() {
        return basket;
    }
    public void addProduct(Product product) {
        int index = searchForProduct(product);
        if (index >= 0) {
            basket.get(index).setPrice(basket.get(index).getPrice() + product.getPrice() * product.getPiece());
            basket.get(index).setPiece(basket.get(index).getPiece() + product.getPiece());
        } else {
            product.setPrice(product.getPrice() * product.getPiece());
            basket.add(product);
        }
    }
    private int searchForProduct(Product product) {
        for (Product element : this.basket) {
            if (element.getName().toLowerCase().contains(product.getName().toLowerCase())) {
                return basket.indexOf(element);
            }
        }
        return -1;
    }
    public String toString() {
        return "Costumer name: " + name + ", age: " + age + " old (" + (isAdult ? "Adult" : "Underage")
                + ")" + ", current money: " + money + " Ft.";
    }
}
