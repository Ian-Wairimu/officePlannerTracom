package ke.co.tracom.officeplanner.controller;

import ke.co.tracom.officeplanner.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(User.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message", "hello, world!");
        LOGGER.info("inside department controller");
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
