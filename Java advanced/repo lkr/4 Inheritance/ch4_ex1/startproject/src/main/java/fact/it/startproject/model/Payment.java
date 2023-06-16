package fact.it.startproject.model;

import javax.persistence.*;
import java.text.MessageFormat;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beneficiary;
    private double amount;
    private String currency;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Override
    public String toString(){
        return MessageFormat.format("{0} {1}{2}", this.beneficiary, this.amount, this.currency);
    }
}
