package ke.co.tracom.officeplanner.entity.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Name {
    @Column(nullable = false, name = "first_name")
    private String firstname;
    @Column(nullable = false, name = "middle_name")
    private String middleName;
    @Column(nullable = false)
    private String surname;

    public Name() {
    }

    public Name(String firstname, String middleName, String surname) {
        this.firstname = firstname;
        this.middleName = middleName;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstname, name.firstname) && Objects.equals(middleName, name.middleName) && Objects.equals(surname, name.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, middleName, surname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstname='" + firstname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
