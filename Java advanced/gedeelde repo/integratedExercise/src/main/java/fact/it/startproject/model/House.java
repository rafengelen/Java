package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class House extends Property{
    private boolean townhouse;

    public House() {
    }

    public boolean isTownhouse() {
        return townhouse;
    }

    public void setTownhouse(boolean townhouse) {
        this.townhouse = townhouse;
    }
    @Override
    public String toString(){
        String message = "Detached house (";
        if (townhouse){
            message = "Townhouse (";
        }
        return message + super.getCode()+") with " + super.getContractList().stream().count() +" contract(s)";
    }
}
