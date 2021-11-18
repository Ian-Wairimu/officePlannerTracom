package ke.co.tracom.officeplanner.domain.equipment;

import javax.persistence.*;

@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
}
