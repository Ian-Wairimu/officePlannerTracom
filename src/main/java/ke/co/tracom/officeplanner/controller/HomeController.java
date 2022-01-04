package ke.co.tracom.officeplanner.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "index";
        }
        return "redirect:/dashboard";
    }
    @RequestMapping(method = RequestMethod.GET, value =  "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
