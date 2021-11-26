package ke.co.tracom.officeplanner.entity.booking;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

}
