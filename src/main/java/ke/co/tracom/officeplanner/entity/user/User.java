package ke.co.tracom.officeplanner.entity.user;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.organization.Organization;
import ke.co.tracom.officeplanner.entity.user.role.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique_key", columnNames = {"user_email", "user_email"})}
              )
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @Column(nullable = false, name = "user_id")
    private Long id;
    @Embedded
    @Column(nullable = false, name = "user_name")
    private Name name;
    @Column(nullable = false, name = "user_email")
    private String email;
    @Column(nullable = false, name = "user_password")
    private String password;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false, name = "user_phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "fk_users")
    private Organization organization;
    @ManyToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();
    @ManyToMany
    private Set<UserRole> role = new HashSet<>();

    public User() {
    }

    public User(Long id, Name name, String email, String password, String gender, String phone, Organization organization, List<Booking> bookings, Set<UserRole> role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.organization = organization;
        this.bookings = bookings;
        this.role = role;
    }

    public User(Name name, String email, String password, String gender, String phone, Organization organization, List<Booking> bookings, Set<UserRole> role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.organization = organization;
        this.bookings = bookings;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(gender, user.gender) && Objects.equals(phone, user.phone) && Objects.equals(organization, user.organization) && Objects.equals(bookings, user.bookings) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, gender, phone, organization, bookings, role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", organization=" + organization +
                ", bookings=" + bookings +
                ", role=" + role +
                '}';
    }
}
