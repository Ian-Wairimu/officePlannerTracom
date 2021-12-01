package ke.co.tracom.officeplanner.entity.booking;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class BookingTime {
    @Temporal(TemporalType.TIME)
    @Column(nullable = false, name = "start_time")
    private Date startTime;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false, name = "end_time")
    private Date endTime;

    public BookingTime() {
    }

    public BookingTime(Date startTime, Date endTime) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
