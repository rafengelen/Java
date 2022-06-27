package fact.it.exrefuelling.model;

public class Refuelling {
    private int previousMileage;
    private int currentMileage;
    private double amountInLiters;

    public Refuelling(int previousMileage, int currentMileage, double amountInLiters) {
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLiters = amountInLiters;
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

    public double getAmountInLiters() {
        return amountInLiters;
    }

    public void setAmountInLiters(double amountInLiters) {
        this.amountInLiters = amountInLiters;
    }

    public double getFuelConsumption(){
        return getAmountInLiters()*100/(getCurrentMileage()-getPreviousMileage());
    }

}
