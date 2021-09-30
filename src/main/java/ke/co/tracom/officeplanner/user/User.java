package ke.co.tracom.officeplanner.user;

import ke.co.tracom.officeplanner.employee.Employee;
import ke.co.tracom.officeplanner.organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class User {
    @Id
    private Long userId;
    private String userName;
    private String userPassword;

    @OneToOne
    private Employee employee;

}
