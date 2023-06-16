package fact.it.startproject.model;

import javax.persistence.Entity;
import java.text.MessageFormat;

@Entity
public class ElectronicPayment extends Payment{
    private String clientName;
    private String clientAccount;

    public ElectronicPayment() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }
    @Override
    public String toString(){
        return MessageFormat.format("{0} (clientName: {1} and clientAccount = {2})", super.toString(), this.clientName, this.clientAccount);
    }
}
