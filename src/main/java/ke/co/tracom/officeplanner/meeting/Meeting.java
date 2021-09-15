package ke.co.tracom.officeplanner.meeting;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Meeting {
    @Id
    private Long meetingBrdId;
    private String meetingName;
    private LocalDate meetingDate;
    private LocalTime meetingStart;
    private LocalTime meetingEnd;

    public Meeting() {
    }

    public Meeting(Long meetingBrdId, String meetingName, LocalDate meetingDate, LocalTime meetingStart, LocalTime meetingEnd) {
        this.meetingBrdId = meetingBrdId;
        this.meetingName = meetingName;
        this.meetingDate = meetingDate;
        this.meetingStart = meetingStart;
        this.meetingEnd = meetingEnd;
    }

    public Meeting(String meetingName, LocalDate meetingDate, LocalTime meetingStart, LocalTime meetingEnd) {
        this.meetingName = meetingName;
        this.meetingDate = meetingDate;
        this.meetingStart = meetingStart;
        this.meetingEnd = meetingEnd;
    }

    public Long getMeetingBrdId() {
        return meetingBrdId;
    }

    public void setMeetingBrdId(Long meetingBrdId) {
        this.meetingBrdId = meetingBrdId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public LocalTime getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(LocalTime meetingStart) {
        this.meetingStart = meetingStart;
    }

    public LocalTime getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(LocalTime meetingEnd) {
        this.meetingEnd = meetingEnd;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingBrdId=" + meetingBrdId +
                ", meetingName='" + meetingName + '\'' +
                ", meetingDate=" + meetingDate +
                ", meetingStart=" + meetingStart +
                ", meetingEnd=" + meetingEnd +
                '}';
    }
}
