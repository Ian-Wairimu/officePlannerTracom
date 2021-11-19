package ke.co.tracom.officeplanner.domain.organization;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "organizations")
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Organization {
    @SequenceGenerator(
            name = "organization_sequence",
            sequenceName = "organization_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "organization_sequence")
    @Column(name = "organization_id")
    private Long id;
    @Column(name = "organization_name", unique = true, nullable = false)
    @NotNull
    private String name;
    @Column(name = "organization_capacity", nullable = false)
    @NotNull
    private Integer number;
}
