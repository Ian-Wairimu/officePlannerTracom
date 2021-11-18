package ke.co.tracom.officeplanner.domain.user;

import ke.co.tracom.officeplanner.configuration.AppUserRole;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "user_name")
    @NotNull
    @NotBlank(message = "please insert user name")
    private Name names;
    @Column(name = "user_email", unique = true)
    @NotNull
    private String email;
    @Column(name = "user_password", unique = true)
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private Boolean locked;

    private Boolean enabled;

    //constructor with nothing but id

}
