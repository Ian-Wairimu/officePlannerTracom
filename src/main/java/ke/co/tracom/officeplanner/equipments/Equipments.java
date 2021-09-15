package ke.co.tracom.officeplanner.equipments;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipments {
    @Id
    private Long equipmentId;
    private Integer capacity;
    private String tvForDisplay;
    private String whiteboard;
    private String phone;

    public Equipments() {
    }

    public Equipments(Long equipmentId, Integer capacity, String tvForDisplay, String whiteboard, String phone) {
        this.equipmentId = equipmentId;
        this.capacity = capacity;
        this.tvForDisplay = tvForDisplay;
        this.whiteboard = whiteboard;
        this.phone = phone;
    }

    public Equipments(Integer capacity, String tvForDisplay, String whiteboard, String phone) {
        this.capacity = capacity;
        this.tvForDisplay = tvForDisplay;
        this.whiteboard = whiteboard;
        this.phone = phone;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getTvForDisplay() {
        return tvForDisplay;
    }

    public void setTvForDisplay(String tvForDisplay) {
        this.tvForDisplay = tvForDisplay;
    }

    public String getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(String whiteboard) {
        this.whiteboard = whiteboard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Equipments{" +
                "equipmentId=" + equipmentId +
                ", capacity=" + capacity +
                ", tvForDisplay='" + tvForDisplay + '\'' +
                ", whiteboard='" + whiteboard + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
