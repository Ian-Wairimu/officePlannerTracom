package ke.co.tracom.officeplanner.equipments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipments {
    @Id
    private Long equipmentId;
    private Integer capacity;
    private String tvForDisplay;
    private String whiteboard;
    private String phone;

}
