package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.domain.boardroom.Boardroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardroomRepository extends JpaRepository<Boardroom, Long> {
}