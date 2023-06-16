package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Waiter extends Staff{


    public Waiter() {
    }
    public Waiter(String name){super.setName(name);}
    public void update(){
        EntranceCounter subject = EntranceCounter.getInstance();
        System.out.println("I am "+ super.getName() + " and I start preparing the table for " + subject.getNumber() + " customers.");
    }
}
