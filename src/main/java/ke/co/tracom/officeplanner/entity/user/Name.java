package ke.co.tracom.officeplanner.entity.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
    @Column(nullable = false, name = "first_name")
    private String firstname;
    @Column(nullable = false, name = "middle_name")
    private String middleName;
    @Column(nullable = false)
    private String surname;
}
