package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class Apartment extends Property{
    private int floor;

    public Apartment() {
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString(){
        return "Appartement ("+super.getCode()+") on floor: " + this.floor +" with " + super.getContractList().stream().count() +" contract(s)";
    }
}
