package ke.co.tracom.officeplanner.controller.planner;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/booking")
    public String booking(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/booking")
    public String bookingSave(@Valid @ModelAttribute("booking") Booking booking, Model model, BindingResult result) {
        model.addAttribute("booking", booking);
        bookingService.bookingSave(booking);
        if (result.hasErrors()) {
            return "booking";
        }
        else {
            return "redirect:/dashboard";
        }
    }
}
