package ke.co.tracom.officeplanner.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String employeeGender;
    private String employeeEmail;
    private String employeePhone;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeGender, String employeeEmail, String employeePhone) {
        this.employeeId = employeeId;
        this.employeeGender = employeeGender;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }

    public Employee(String employeeGender, String employeeEmail, String employeePhone) {
        this.employeeGender = employeeGender;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                '}';
    }
}
