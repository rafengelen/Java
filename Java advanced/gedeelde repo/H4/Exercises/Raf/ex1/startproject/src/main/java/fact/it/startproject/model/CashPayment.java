package fact.it.startproject.model;

import javax.persistence.*;
import java.text.MessageFormat;

@Entity
public class CashPayment extends Payment{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return MessageFormat.format("{0} is a Cash Payment from {1}.",super.toString(), this.name);
    }
}
