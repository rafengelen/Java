package fact.it.startproject.model;

import javax.persistence.Embeddable;

@Embeddable
public class Time {
    private int minutes,year;

    public Time() {
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
