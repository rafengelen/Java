package fact.it.supplier.model;

public class Supplier extends Company{
    /*
     * Raf Engelen
     * 1ITF02
     * r0901812
     */
    private int totalOrders;
    private ContactPerson contactPerson;

    public Supplier() {
        this.totalOrders = 1;
    }

    public Supplier(String companyName, boolean active) {
        super(companyName, active);
        this.totalOrders = 1;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void addOrder(){
        totalOrders++;
    }

    public void addNewContactPerson(String name, String phoneNumber){
        ContactPerson newContactPerson = new ContactPerson(name);
        newContactPerson.setPhoneNumber(phoneNumber);

        this.contactPerson = newContactPerson;
    }

    public String toString(){
        String textContactPerson;
        String text = getCompanyName();
        if (contactPerson == null){
            textContactPerson = " has no contact person and ";
            text += " has no contact person and ";
        }
        else {
            textContactPerson = " has a contact person and ";
            text += " has a contact person and ";
        }

        text += totalOrders + " order(s).";

        if (!isActive()){
            text += " (Not Active)";
        }

        return text;
    }
}
