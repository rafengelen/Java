package fact.it.exthermostat.model;

public class Thermostat {
    private int temperature, maxTemp, minTemp, increment;

    public Thermostat(int temperature, int maxTemp, int minTemp, int increment) {
        if (maxTemp < minTemp){
            int tmp = minTemp;
            minTemp = maxTemp;
            maxTemp = tmp;
        }
        this.temperature = temperature;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.increment = increment;



        if(temperature>maxTemp||temperature<minTemp){
            this.temperature = (maxTemp + minTemp)/2;
        }

        if(increment<0){
            this.increment *= -1;
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
        if(increment<0){
            this.increment *= -1;
        }
    }

    public void warmer() {
        if(this.temperature + increment> this.maxTemp){
            this.temperature = this.maxTemp;
        }
        else {
            this.temperature += this.increment;
        }
    }

    public void warmer(int amountIncrement) {
        if(this.temperature + amountIncrement> this.maxTemp){
            this.temperature = this.maxTemp;
        }
        else {
            this.temperature += amountIncrement;
        }
    }

    public void colder(){
        if(this.temperature - increment < this.minTemp){
            this.temperature = this.minTemp;
        }
        else {
            this.temperature -= this.increment;
        }
    }
    public void colder(int amountIncrement){
        if(this.temperature - amountIncrement < this.minTemp){
            this.temperature = this.minTemp;
        }
        else {
            this.temperature -= amountIncrement;
        }
    }
}
