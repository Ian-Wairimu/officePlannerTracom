package ke.co.tracom.officeplanner.entity.booking;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence"
    )
    @Column(nullable = false, name = "booking_id")
    private Long id;
    @Column(nullable = false, name = "booking_name")
    private String name;
    @Column(nullable = false, name = "booking_description")
    private String description;
    @Embedded
    private Equipment equipment;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "booking_date")
    private Date bookingDate;
    @Embedded
    private BookingTime time;
}
