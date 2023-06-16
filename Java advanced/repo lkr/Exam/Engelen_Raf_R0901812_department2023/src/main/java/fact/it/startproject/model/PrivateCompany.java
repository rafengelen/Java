package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class PrivateCompany extends Company{
    private String ownerName;

    public PrivateCompany() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;

    }
    @Override
    public String toString(){
        return super.toString() + " This is a private company with owner "+this.ownerName;
    }

}
