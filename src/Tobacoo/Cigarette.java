package Tobacoo;
public class Cigarette {
	private String name;
	private int price;
	private int piece;
	public Cigarette(String name, int price, int piece) {
		this.name = name;
		this.price = price;
		this.piece = piece;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	@Override
	public String toString() {
		return name + ", price " + price + ", piece " + piece;
	}
}
