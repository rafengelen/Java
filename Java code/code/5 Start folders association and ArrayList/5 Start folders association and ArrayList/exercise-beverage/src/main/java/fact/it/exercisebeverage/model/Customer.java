package fact.it.exercisebeverage.model;

import java.util.Locale;

public class Customer {
    private int customerNumber;
    private String name;

    public Customer(int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretCode(){
        return name.substring(0,2).toUpperCase() + customerNumber + name.substring(name.length()-2).toUpperCase();
    }
}
