package ke.co.tracom.officeplanner.entity.booking;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class BookingTime {
//    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "start_time")
    private LocalTime  startTime;
//    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "end_time")
    private LocalTime endTime;

    public BookingTime() {
    }

    public BookingTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingTime that = (BookingTime) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BookingTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
