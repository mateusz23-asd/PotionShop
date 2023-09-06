package Tobacoo;
public class Cigar extends Cigarette {
    private String flavor;
    public Cigar(String name,int price,int piece,String flavor) {
        super(name,price,piece);
        this.flavor = flavor;
    }
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    @Override
    public String toString() {
        return super.toString() + " Flavor: " + flavor;
    }
}
