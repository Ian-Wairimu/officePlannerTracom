package ke.co.tracom.officeplanner.boardroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boardroom {
    @Id
    private Long boardroomId;
    private String boardroomName;

}
