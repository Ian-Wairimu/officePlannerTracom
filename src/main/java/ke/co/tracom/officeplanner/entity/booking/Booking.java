package ke.co.tracom.officeplanner.entity.booking;

import ke.co.tracom.officeplanner.entity.organization.Organization;
import ke.co.tracom.officeplanner.entity.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
//    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bookingDate;
    @Embedded
    private BookingTime time;
    @ManyToMany
    @JoinTable(
            name = "user_booking",
            joinColumns = {@JoinColumn(name = "fk_bookings")},
            inverseJoinColumns = {@JoinColumn(name = "fk_users")}
    )
    private List<User> user = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "fk_organization")
    private Organization organization;

    public Booking() {
    }

    public Booking(Long id, String name, String description, Equipment equipment, LocalDate bookingDate, BookingTime time, List<User> user, Organization organization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.equipment = equipment;
        this.bookingDate = bookingDate;
        this.time = time;
        this.user = user;
        this.organization = organization;
    }

    public Booking(String name, String description, Equipment equipment, LocalDate bookingDate, BookingTime time, List<User> user, Organization organization) {
        this.name = name;
        this.description = description;
        this.equipment = equipment;
        this.bookingDate = bookingDate;
        this.time = time;
        this.user = user;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingTime getTime() {
        return time;
    }

    public void setTime(BookingTime time) {
        this.time = time;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", equipment=" + equipment +
                ", bookingDate=" + bookingDate +
                ", time=" + time +
                ", users=" + user +
                ", organization=" + organization +
                '}';
    }
}
