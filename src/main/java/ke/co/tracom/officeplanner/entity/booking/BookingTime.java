package ke.co.tracom.officeplanner.entity.booking;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class BookingTime {
    @Temporal(TemporalType.TIME)
    @Column(nullable = false, name = "start_time")
    private Date startTime;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false, name = "end_time")
    private Date endTime;
}
