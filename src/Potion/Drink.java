package Potion;
public class Drink {
    private String name;
    private int price;
    private int piece;
    private double wrecking;
    public Drink(String name,int price,int piece,double wrecking) {
        this.name = name;
        this.price = price;
        this.piece = piece;
        this.wrecking = wrecking;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
    }
    public String toString() {
        return name + ", price: " + price + ", piece: " + piece + ", wrecking: " + wrecking + "L  ";
    }
}
