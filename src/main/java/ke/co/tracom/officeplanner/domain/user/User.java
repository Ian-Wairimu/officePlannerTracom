package ke.co.tracom.officeplanner.domain.user;

import ke.co.tracom.officeplanner.configuration.AppUserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    @Column(name = "user_id")
    private Long id;
    @Embedded
    @Column(name = "user_name", unique = false, nullable = false)
    @NotBlank(message = "please insert user name")
    private Name names;
    @Column(name = "user_email", unique = true, nullable = false)
    @NotBlank(message = "please enter email")
    private String email;
    @Column(name = "user_password", unique = true, nullable = false)
    @NotBlank(message = "please enter password")
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private Boolean locked;

    private Boolean enabled;

    //constructor with nothing but id


    public User() {
    }

    public User(Long id, Name names, String email, String password, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    public User(Name names, String email, String password, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.names = names;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
}
