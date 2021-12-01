package ke.co.tracom.officeplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String home(){
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/loginPage")
    public String login(){
        return "login-page";
    }
}
