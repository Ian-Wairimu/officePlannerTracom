package ke.co.tracom.officeplanner.entity.user;

import ke.co.tracom.officeplanner.entity.user.role.UserRole;

import javax.persistence.*;
import java.io.Serializable;

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
    @Enumerated
    @Column(name = "user_role")
    private UserRole role;

}
