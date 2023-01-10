package Customer;



public class Customer {

	private String name;
	private int age;
	private double money;
	private boolean isAdult;
	private String pruchasedThings = "\nPurcashed things:";

	
	
	public Customer(String name, int age, double money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
		if (age < 18 && age > 0) {
			isAdult = false;
		} else {
			isAdult = true;
		}
		
	}
	
	public void purcashedThings(int piece, String name, int price, String which) {
		
		this.pruchasedThings += "\n" + name + " " + which + ", " + piece + " piece(s) "
				+ price + " Ft.";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	
	public String getPruchasedThings() {
		return pruchasedThings;
	}
	public void setPruchasedThings(String pruchasedThings) {
		this.pruchasedThings = pruchasedThings;
	}
	
	public String toString() {
		return "Costumer name: " + name + ", age: " + age + " old (" + (isAdult ? "Adult" : "Under age")
				+ ")" + ", current money: " + money + " Ft.";
	}
}
