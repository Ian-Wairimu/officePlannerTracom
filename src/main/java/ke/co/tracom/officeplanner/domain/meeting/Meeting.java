package ke.co.tracom.officeplanner.domain.meeting;

import ke.co.tracom.officeplanner.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meetings")
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Meeting {
    @SequenceGenerator(
            name = "meeting_sequence",
            sequenceName = "meeting_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "meeting_sequence")
    @Column(name = "meeting_id")
    private Long id;
    @Column(name = "meeting_name", unique = true, nullable = false)
    private String name;
    @Column(name = "meeting_topic", unique = false, nullable = false)
    private String topic;
    @Column(name = "meeting_description", unique = false, nullable = false)
    private String desc;

}
