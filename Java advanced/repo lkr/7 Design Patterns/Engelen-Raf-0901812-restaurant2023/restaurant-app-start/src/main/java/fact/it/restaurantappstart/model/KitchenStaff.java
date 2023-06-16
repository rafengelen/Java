package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class KitchenStaff extends Staff {

    public KitchenStaff() {
    }
    public KitchenStaff(String name){super.setName(name);}
    public void update(){
        EntranceCounter subject = EntranceCounter.getInstance();
        System.out.println("I am " + super.getName() + " and I start now with preparing " + subject.getNumber() + " appetizers!"
        );
    }
}
