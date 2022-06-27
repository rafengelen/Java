package fact.it.supplier.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContactPerson {
    private String phoneNumber, name;
    private LocalDate lastContact;

    public ContactPerson(String name) {
        /*
         * Raf Engelen
         * 1ITF02
         * r0901812
         */
        this.name = name;
        this.lastContact = LocalDate.now();
        this.phoneNumber = "(phone number is not set)";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String temporaryNumber = "";
        if(phoneNumber.charAt(0)=='0' && phoneNumber.length()==10){
            for (int position = 0; position < phoneNumber.length(); position++){
                temporaryNumber += phoneNumber.substring(position,position+1);
                if (position == 3){
                    temporaryNumber += '/';
                }
                else if (position == 5 || position == 7){
                    temporaryNumber += '.';
                }
            }
            this.phoneNumber = temporaryNumber;

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastContact() {
        return lastContact;
    }

    public void setLastContact(LocalDate lastContact) {
        this.lastContact = lastContact;
    }

    public String toString(){
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("d/M/yy");
        String formattedLastContact = lastContact.format(dtf);
        return name + ' ' + phoneNumber + " Last contact " + formattedLastContact;
    }
}
