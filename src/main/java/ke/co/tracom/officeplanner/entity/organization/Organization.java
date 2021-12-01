package ke.co.tracom.officeplanner.entity.organization;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.user.User;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "organizations",
        uniqueConstraints = {
                @UniqueConstraint(name = "organization_name_unique_key", columnNames = {"org_name", "org_name"})}
)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_sequence")
    @SequenceGenerator(
            name = "org_sequence",
            sequenceName = "org_sequence"
    )
    @Column(nullable = false, name = "org_id")
    private Long id;
    @Column(nullable = false, name = "org_name")
    private String name;
    @Column(nullable = false, name = "org_capacity")
    private Integer capacity;
    @OneToMany(mappedBy = "organization")
    private List<User> userList = new ArrayList<>();
    @OneToMany(mappedBy = "organization")
    private Set<Booking> booking = new HashSet<>();

    public Organization() {
    }

    public Organization(Long id, String name, Integer capacity, List<User> userList, Set<Booking> booking) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.userList = userList;
        this.booking = booking;
    }

    public Organization(String name, Integer capacity, List<User> userList, Set<Booking> booking) {
        this.name = name;
        this.capacity = capacity;
        this.userList = userList;
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(capacity, that.capacity) && Objects.equals(userList, that.userList) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, userList, booking);
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", userList=" + userList +
                ", booking=" + booking +
                '}';
    }
}
