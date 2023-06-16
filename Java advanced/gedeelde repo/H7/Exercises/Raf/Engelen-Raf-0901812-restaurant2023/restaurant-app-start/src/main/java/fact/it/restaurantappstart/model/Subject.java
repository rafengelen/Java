package fact.it.restaurantappstart.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Staff> observers = new ArrayList<Staff>();

    public void attachObserver(Staff observer){
        observers.add(observer);
    }
    public void detachObserver(Staff observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for (Staff observer : observers) {
            observer.update();
        }
    }

    public void setObservers(List<Staff> observers) {
        this.observers = observers;
    }

    public List<Staff> getObservers() {
        return observers;
    }
}
