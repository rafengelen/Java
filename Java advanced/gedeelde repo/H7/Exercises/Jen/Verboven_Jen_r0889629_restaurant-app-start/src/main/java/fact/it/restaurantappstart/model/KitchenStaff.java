package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitchenStaff extends Staff {

    public KitchenStaff() {
    }

    public KitchenStaff(String name){
        super.setName(name);
    }

    @Override
    public void update(){
        EntranceCounter entranceCounter = EntranceCounter.getInstance();
        System.out.println("I am " + super.getName() + " and I start now with preparing " + entranceCounter.getNumber() + " appetizers!");
    }
}
