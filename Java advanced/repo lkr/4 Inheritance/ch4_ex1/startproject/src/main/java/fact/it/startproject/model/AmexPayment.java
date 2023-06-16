package fact.it.startproject.model;

import javax.persistence.Entity;
import java.text.MessageFormat;

@Entity
public class AmexPayment extends ElectronicPayment{
    private int pinCode;

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    public String toString(){
        return MessageFormat.format("{0} is an Amex Payment with pinCode of {1} characters.",
                super.toString(),
                String.valueOf(this.pinCode).length());
    }
}
