package ke.co.tracom.officeplanner.boardroom;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boardroom {
    @Id
    private Long boardroomId;
    private String boardroomName;

    public Boardroom() {
    }

    public Boardroom(Long boardroomId, String boardroomName) {
        this.boardroomId = boardroomId;
        this.boardroomName = boardroomName;
    }

    public Boardroom(String boardroomName) {
        this.boardroomName = boardroomName;
    }

    public Long getBoardroomId() {
        return boardroomId;
    }

    public void setBoardroomId(Long boardroomId) {
        this.boardroomId = boardroomId;
    }

    public String getBoardroomName() {
        return boardroomName;
    }

    public void setBoardroomName(String boardroomName) {
        this.boardroomName = boardroomName;
    }

    @Override
    public String toString() {
        return "Boardroom{" +
                "boardroomId=" + boardroomId +
                ", boardroomName='" + boardroomName + '\'' +
                '}';
    }
}
