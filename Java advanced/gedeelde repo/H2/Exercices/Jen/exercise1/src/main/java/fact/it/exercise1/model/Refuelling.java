package fact.it.exercise1.model;

public class Refuelling {
    private int id, previousMileage, currentMileage;
    private double amountInLitres;

    public Refuelling(int id, int previousMileage, int currentMileage, double amountInLitres) {
        this.id = id;
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLitres = amountInLitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public double getFuelComsumption(){
        return (amountInLitres / (currentMileage - previousMileage)) * 100;
    }
}
