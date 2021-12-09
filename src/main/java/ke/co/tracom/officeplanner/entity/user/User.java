package ke.co.tracom.officeplanner.entity.user;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.organization.Organization;
import ke.co.tracom.officeplanner.entity.user.role.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique_key", columnNames = {"user_email", "user_email"})}
              )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @Column(name = "user_id")
    private Long id;
    @Embedded
    private Name name;
    @Column(nullable = false, name = "user_email")
    private String email;
    @Column(nullable = true, name = "user_password")
    private String password;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false, name = "user_phone")
    private String phone;
    @Column(name = "is_enabled")
    private Boolean enabled;
    @ManyToOne
    @JoinColumn(name = "fk_users")
    private Organization organization;
    @ManyToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();
    @ManyToMany
    private Set<UserRole> role = new HashSet<>();
}
