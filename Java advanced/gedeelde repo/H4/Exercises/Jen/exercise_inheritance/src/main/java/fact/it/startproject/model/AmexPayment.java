package fact.it.startproject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@DiscriminatorValue("Amex Payment")
@Entity
public class AmexPayment extends ElectronicPayment{
    private int pinCode;

    public AmexPayment() {
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
