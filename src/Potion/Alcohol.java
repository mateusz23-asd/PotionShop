package Potion;
public class Alcohol extends Drink{
	private double alcoholPercentage;
	public Alcohol(String name, int price, int piece, double wrecking, double alcoholPercentage) {
		super(name, price, piece, wrecking);
		this.alcoholPercentage = alcoholPercentage;
	}
	public String toString() {
		return super.toString() + "Alcohol strength " + alcoholPercentage + " %.";
	}
}
