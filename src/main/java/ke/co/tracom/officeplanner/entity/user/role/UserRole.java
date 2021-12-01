package ke.co.tracom.officeplanner.entity.user.role;

import ke.co.tracom.officeplanner.entity.user.User;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_sequence")
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence"
    )
    @Column(nullable = false, name = "role_id")
    private Long id;
    @Column(name = "user_role")
    private String name;
    @ManyToMany
    private Set<User> user = new HashSet<>();

    public UserRole() {
    }

    public UserRole(Long id, String name, Set<User> user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public UserRole(String name, Set<User> user) {
        this.name = name;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id) && Objects.equals(name, userRole.name) && Objects.equals(user, userRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
