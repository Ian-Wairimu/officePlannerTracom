package ke.co.tracom.officeplanner.controller;

import ke.co.tracom.officeplanner.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
