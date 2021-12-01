package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.entity.user.role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}