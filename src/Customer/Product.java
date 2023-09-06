package Customer;
public class Product {
    private String name;
    private int price;
    private int piece;
    private int pcPrice;
    public Product(String name,int price,int piece, int pcPrice) {
        this.name = name;
        this.price = price;
        this.piece = piece;
        this.pcPrice = pcPrice;
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
        return name.toUpperCase() + "  " + price + "Ft  " + piece + "X " + pcPrice + "Ft";
    }
}
