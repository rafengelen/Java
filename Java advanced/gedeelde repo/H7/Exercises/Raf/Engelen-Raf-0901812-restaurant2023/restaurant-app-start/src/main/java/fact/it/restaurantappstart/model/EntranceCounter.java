package fact.it.restaurantappstart.model;

public class EntranceCounter extends Subject{
    private int number;
    private static EntranceCounter entranceCounter;
    private EntranceCounter() {}
    public static EntranceCounter getInstance() {
        if (entranceCounter == null) {
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        this.notifyObservers();
    }

    public static EntranceCounter getEntranceCounter() {
        return entranceCounter;
    }

    public static void setEntranceCounter(EntranceCounter entranceCounter) {
        EntranceCounter.entranceCounter = entranceCounter;
    }




}
