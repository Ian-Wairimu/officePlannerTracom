package ke.co.tracom.officeplanner.employee;

import ke.co.tracom.officeplanner.organization.Organization;
import ke.co.tracom.officeplanner.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long employeeId;
    private String employeeGender;
    private String employeeEmail;
    private String employeePhone;
}
