package fact.it.exercisedairy.model;

public class Dairy extends Product{

    private int numberOfDays;
    private char supplierCode;

    public Dairy(int productNumber) {
        super(productNumber);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public char getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(char supplierCode) {
        this.supplierCode = supplierCode;
    }

    public void lowerFreshness(){
        this.numberOfDays -= 1;
    }

    public void fastSale(int minimumNumberOfDays){
        if (numberOfDays<=minimumNumberOfDays){
            setUnitPrice(getUnitPrice()/2);
        }
    }
}
