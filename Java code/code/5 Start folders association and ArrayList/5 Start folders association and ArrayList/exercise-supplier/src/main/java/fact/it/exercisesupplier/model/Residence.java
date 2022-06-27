package fact.it.exercisesupplier.model;

public class Residence {
    private String streetAndNumber;
    private int zipCode;
    private String municipality;

    public Residence() {
        this.streetAndNumber = "no data";
        this.zipCode = 0;
        this.municipality = "no data";
    }

    public Residence(String streetAndNumber, int zipCode, String municipality) {
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
        this.municipality = municipality;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
