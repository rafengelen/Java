package fact.it.examplebicycle.model;
import java.time.LocalDate;

public class Reservation {
    private Bicycle bicycle;
    private LocalDate startDate;

    public Reservation() {
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDate() {
        return startDate.getDayOfMonth() + "/" + startDate.getMonthValue() + "/" + startDate.getYear();
    }
}
