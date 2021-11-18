package ke.co.tracom.officeplanner.domain.meeting;

import ke.co.tracom.officeplanner.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meeting_id")
    private Long id;
    @Column(name = "meeting_name")
    private String name;
    @Column(name = "meeting_topic")
    private String topic;
    @Column(name = "meeting_description")
    private String desc;

}
