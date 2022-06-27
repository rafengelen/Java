package fact.it.exercisedairy.model;

public class Product {
    private int productNumber;
    private String name;
    private double unitPrice;

    public Product() {
    }

    public Product(int productNumber) {
        this.productNumber = productNumber;
    }

    public Product(int productNumber, String name, double unitPrice) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString(){
        return this.productNumber +" "+this.name +": € "+this.unitPrice;
    }


}
