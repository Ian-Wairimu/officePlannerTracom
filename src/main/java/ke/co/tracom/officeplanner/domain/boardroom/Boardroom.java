package ke.co.tracom.officeplanner.domain.boardroom;

import javax.persistence.*;

@Entity
@Table(name = "boardrooms")
public class Boardroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boardroom_id")
    private Long id;
    @Column(name = "boardroom_name")
    private String name;
}
