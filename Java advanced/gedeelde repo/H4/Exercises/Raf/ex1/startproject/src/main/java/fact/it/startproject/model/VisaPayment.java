package fact.it.startproject.model;

import javax.persistence.Entity;
import java.text.MessageFormat;

@Entity
public class VisaPayment extends ElectronicPayment{
    private String cardNumber;
    private String expirationData;

    public VisaPayment() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationData() {
        return expirationData;
    }

    public void setExpirationData(String expirationData) {
        this.expirationData = expirationData;
    }
    @Override
    public String toString(){
        return MessageFormat.format("{0} is a Visa Payment with cardNumber = {1} and expirationDate = {2}",
                super.toString(),
                this.cardNumber,
                this.expirationData);
    }
}
