package ke.co.tracom.officeplanner.meeting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    @Id
    private Long meetingBrdId;
    private String meetingName;
    private LocalDate meetingDate;
    private LocalTime meetingStart;
    private LocalTime meetingEnd;
}
