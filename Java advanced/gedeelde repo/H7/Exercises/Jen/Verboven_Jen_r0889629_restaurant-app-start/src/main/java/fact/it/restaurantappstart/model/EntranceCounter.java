package fact.it.restaurantappstart.model;


import java.util.List;

public final class EntranceCounter extends Subject {
    private int number;
    private static EntranceCounter entranceCounter;

    public EntranceCounter() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        this.notifyObservers();
    }

    public static EntranceCounter getInstance() {
        if (entranceCounter == null) {
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }

    @Override
    public void attachObserver(Staff observer) {
        super.observers.add(observer);
    }

    @Override
    public void detachObserver(Staff observer) {
        super.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Staff observer : super.observers){
            observer.update();
        }
    }
}
