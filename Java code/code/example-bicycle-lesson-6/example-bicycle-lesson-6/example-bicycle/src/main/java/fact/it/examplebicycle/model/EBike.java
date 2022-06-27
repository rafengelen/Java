package fact.it.examplebicycle.model;

public class EBike extends Bicycle {
    private int battery;
    private boolean speedBike;

    public EBike(String type, int year) {
        super(type, year);
        battery = 300;
        speedBike = false;
    }

    public EBike(int battery, boolean speedBike, String type) {
        this.battery = battery;
        this.speedBike = speedBike;
        setType(type);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public boolean isSpeedBike() {
        return speedBike;
    }

    public void setSpeedBike(boolean speedBike) {
        this.speedBike = speedBike;
    }

    public double getPricePerYear() {
        return getRentalPrice() * 12;
    }

    public String toString() {
        if (speedBike) {
            return "This is a speedBike.";
        } else {
            return "This is a normal eBike";
        }
    }

//    public String toString(){
//        return super.toString()+ ", battery= "+ battery;
//    }
}
