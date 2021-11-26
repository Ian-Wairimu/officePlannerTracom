package ke.co.tracom.officeplanner.entity.organization;

import javax.persistence.*;

@Entity
@Table(name = "organizations",
        uniqueConstraints = {
                @UniqueConstraint(name = "organization_name_unique_key", columnNames = {"org_name", "org_name"})}
)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_sequence")
    @SequenceGenerator(
            name = "org_sequence",
            sequenceName = "org_sequence"
    )
    @Column(nullable = false, name = "org_id")
    private Long id;
    @Column(nullable = false, name = "org_name")
    private String name;
    @Column(nullable = false, name = "org_capacity")
    private Integer capacity;

}
