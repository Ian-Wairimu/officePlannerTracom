package ke.co.tracom.officeplanner.controller.planner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingTable {
    @RequestMapping(value = "/booking-table", method = RequestMethod.GET)
    public String table(){
        return "this is a table";
    }
}
