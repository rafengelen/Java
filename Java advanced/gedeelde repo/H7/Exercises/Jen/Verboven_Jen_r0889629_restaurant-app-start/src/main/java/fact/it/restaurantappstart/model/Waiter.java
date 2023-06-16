package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Waiter extends Staff{

    public Waiter() {
    }

    public Waiter(String name){
        super.setName(name);
    }

    @Override
    public void update(){
        EntranceCounter entranceCounter = EntranceCounter.getInstance();
        System.out.println("I am " + this.getName() + " and I start preparing the table for " + entranceCounter.getNumber() + " customers.");
    }
}
