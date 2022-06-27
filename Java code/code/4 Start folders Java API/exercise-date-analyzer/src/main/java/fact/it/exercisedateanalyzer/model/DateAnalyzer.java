package fact.it.exercisedateanalyzer.model;
import org.apache.tomcat.jni.Local;

import java.time. format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;


public class DateAnalyzer {
    private LocalDate date;

    public DateAnalyzer(String date) {
        DateTimeFormatter sequence = DateTimeFormatter.ofPattern ("d/M/yyyy");
        this.date = LocalDate.parse(date, sequence);
    }

    public String getDate() {
        DateTimeFormatter sequence = DateTimeFormatter.ofPattern ("d-M-yyyy");

        return this.date.format(sequence);
    }

    public int getNumberedDayOfTheYear(){
        return this.date.getDayOfYear();
    }
    public int getNumberedDayOfTheMonth(){
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek(){
        return date.getDayOfWeek();
    }

    public Month getMonth() {
        return date.getMonth();
    }

    public String get100DaysOld(){
        LocalDate myDate = date.plusDays(100);
        DateTimeFormatter sequence = DateTimeFormatter.ofPattern ("d-M-yyyy");

        return myDate.format(sequence);
    }

    public String get10MonthsOld(){
        LocalDate myDate = date.plusMonths(10);
        DateTimeFormatter sequence = DateTimeFormatter.ofPattern ("d-M-yyyy");

        return myDate.format(sequence);
    }


}
