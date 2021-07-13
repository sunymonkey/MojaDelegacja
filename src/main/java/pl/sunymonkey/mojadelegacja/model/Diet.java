package pl.sunymonkey.mojadelegacja.model;


import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;


public class Diet {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fromTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime toTime;
    private int countBreakfast;
    private int countDinner;
    private int countSupper;
    private Long country;

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public int getCountBreakfast() {
        return countBreakfast;
    }

    public void setCountBreakfast(int countBreakfast) {
        this.countBreakfast = countBreakfast;
    }

    public int getCountDinner() {
        return countDinner;
    }

    public void setCountDinner(int countDinner) {
        this.countDinner = countDinner;
    }

    public int getCountSupper() {
        return countSupper;
    }

    public void setCountSupper(int countSupper) {
        this.countSupper = countSupper;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
