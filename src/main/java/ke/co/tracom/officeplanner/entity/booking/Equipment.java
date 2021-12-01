package ke.co.tracom.officeplanner.entity.booking;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Equipment {
    @Column(name = "capacity_count")
    private Integer capacity;
    @Column(name = "tv_display")
    private String display;
    @Column(name = "whiteboard")
    private String board;
    @Column(name = "conference_phone")
    private String phone;

    public Equipment() {
    }

    public Equipment(Integer capacity, String display, String board, String phone) {
        this.capacity = capacity;
        this.display = display;
        this.board = board;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(capacity, equipment.capacity) && Objects.equals(display, equipment.display) && Objects.equals(board, equipment.board) && Objects.equals(phone, equipment.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, display, board, phone);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "capacity=" + capacity +
                ", display='" + display + '\'' +
                ", board='" + board + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
