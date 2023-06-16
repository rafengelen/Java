package fact.it.exerciserandomgenerator.model;

import java.util.Random;

public class RandomGenerator {
    private int smallest, number;

    public RandomGenerator() {
        smallest = 1;
        number = 5;
    }

    public RandomGenerator( int number, int smallest) {
        if (smallest < number){
            this.smallest = smallest;
            this.number = number;
        }
        else {
            this.number=smallest;
            this.smallest = number;
        }
    }

    public int getSmallest() {
        return this.smallest;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRandom() {
        Random r = new Random();
        return r.nextInt(smallest)+ number;

    }
}
