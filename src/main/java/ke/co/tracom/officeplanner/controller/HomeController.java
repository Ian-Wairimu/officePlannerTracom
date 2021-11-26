package ke.co.tracom.officeplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcomeHome(){
        return "index";
    }
}
