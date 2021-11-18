package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.domain.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}