package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.domain.equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}