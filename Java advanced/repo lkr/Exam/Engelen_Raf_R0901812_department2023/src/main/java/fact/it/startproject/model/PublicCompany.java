package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class PublicCompany extends Company{
    private boolean federal;

    public PublicCompany() {
    }

    public boolean isFederal() {
        return federal;
    }

    public void setFederal(boolean federal) {
            this.federal = federal;
    }

    @Override
    public String toString(){
        String federal = "Flemish public";
        if (this.federal){
            federal = "federal";
        }
        return super.toString() + " This is a "+ federal + " company";
    }
}
