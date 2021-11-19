package ke.co.tracom.officeplanner.domain.equipment;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "equipments")
@Data
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
}
