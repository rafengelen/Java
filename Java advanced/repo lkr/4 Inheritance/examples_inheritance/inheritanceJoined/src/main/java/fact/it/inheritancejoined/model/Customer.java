package fact.it.inheritancejoined.model;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
    private double discount;

    public Customer() {
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
