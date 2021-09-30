package ke.co.tracom.officeplanner.boardroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardroomRepository extends JpaRepository<Boardroom, Long> {
}