package ke.co.tracom.officeplanner.domain.boardroom;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "boardrooms")
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Boardroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boardroom_id")
    private Long id;
    @Column(name = "boardroom_name", unique = true, nullable = false)
    private String name;
}
