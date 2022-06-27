package fact.it.supplier.model;

public class Company {
    /*
     * Raf Engelen
     * 1ITF02
     * r0901812
     */
    private String companyName;
    private boolean active;

    public Company() {
    }

    public Company(String companyName, boolean active) {
        this.companyName = companyName;
        this.active = active;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString(){
        if (active){
            return companyName;
        }
        return companyName +" (Not Active)";
    }
}
