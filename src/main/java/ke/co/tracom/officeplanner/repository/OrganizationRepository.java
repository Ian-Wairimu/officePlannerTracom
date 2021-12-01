package ke.co.tracom.officeplanner.repository;

import ke.co.tracom.officeplanner.entity.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}