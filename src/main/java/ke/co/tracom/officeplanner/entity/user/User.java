package ke.co.tracom.officeplanner.entity.user;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.organization.Organization;
import ke.co.tracom.officeplanner.entity.user.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique_key", columnNames = {"user_email", "user_email"})}
              )
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "is_enabled")
    private Boolean enabled;
    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;
    @Column(name = "failed_attempt")
    private Integer failedAttempt;
    @Column(name = "lock_time")
    private Date lockTime;
    @ManyToOne
    @JoinColumn(name = "fk_users")
    private Organization organization;
    @ManyToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();
    @ManyToMany
    private Set<UserRole> role = new HashSet<>();


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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Integer getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(Integer failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
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
