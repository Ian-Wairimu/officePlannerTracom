package ke.co.tracom.officeplanner.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
    @Column(name = "first_name")
    private String fName;
    @Column(name = "second_name")
    private String sName;
    @Column(name = "last_name")
    private String lName;
}
