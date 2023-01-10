package Potion;
public class Alcohol extends Drink{
	private double alcoholPrecentage;
	public Alcohol(String name, int price, int piece, double wrecking, double alcoholPrecentage) {
		super(name, price, piece, wrecking);
		this.alcoholPrecentage = alcoholPrecentage;
	}
	public double getAlcoholPrecentage() {
		return alcoholPrecentage;
	}
	public void setAlcoholPrecentage(double alcoholPrecentage) {
		this.alcoholPrecentage = alcoholPrecentage;
	}
	public String toString() {
		return super.toString() + "Alcohol strength " + alcoholPrecentage + " %.";
	}
}
