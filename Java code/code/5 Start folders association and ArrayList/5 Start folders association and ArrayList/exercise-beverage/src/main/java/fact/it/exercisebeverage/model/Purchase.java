package fact.it.exercisebeverage.model;

public class Purchase {
    private int purchasedAmount;
    private Customer customer;
    private Beverage beverage;

    public Purchase(Customer customer, Beverage beverage,int purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
        this.customer = customer;
        this.beverage = beverage;
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }

    public void setPurchasedAmount(int purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public String showPurchase(){
        return "Customer " + customer.getName() + " bought " + purchasedAmount + " bottle(s) of " + beverage.getName() + " (" + beverage.getAlcoholPercentage() + "%)";
}
}
