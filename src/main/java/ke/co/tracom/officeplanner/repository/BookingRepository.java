package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}