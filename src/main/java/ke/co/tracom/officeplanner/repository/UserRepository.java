package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}