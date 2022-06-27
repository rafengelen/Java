package fact.it.exercisebeverage.model;

public class Beverage {
    private String name;
    private double price;
    private int volume;
    private double alcoholPercentage;

    public Beverage() {
    }

    public Beverage(String name, double price, int volume, double alcoholPercentage) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.alcoholPercentage = alcoholPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public boolean isLiquor(){
        if (alcoholPercentage < 35.00) {
            return false;
        }
        return true;
    }

    public double getPricePerLiter(){
        return ((price/volume)*1000);
    }
}
