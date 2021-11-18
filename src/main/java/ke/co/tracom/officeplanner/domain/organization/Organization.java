package ke.co.tracom.officeplanner.domain.organization;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organization_id")
    private Long id;
    @Column(name = "organization_name", unique = false)
    @NotNull
    private String name;
    @Column(name = "organization_capacity")
    @NotNull
    private Integer number;
}
