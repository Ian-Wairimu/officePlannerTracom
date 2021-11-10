package ke.co.tracom.officeplanner.user;

import ke.co.tracom.officeplanner.employee.Employee;
import ke.co.tracom.officeplanner.organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class User {
    @Id
    private Long userId;
//    @Embedded
//    private Name userName;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPassword;


//    @OneToOne
//    private Employee employee;

}
