package ke.co.tracom.officeplanner.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/dashboard").setViewName("dashboard");
    }
    @RequestMapping(method = RequestMethod.GET, value = "/loginForm")
    public String loginHandler(HttpSession session){
        if(session.getAttribute("visited") != null){
            return "/dashboard";
        }else {
            return "login-page";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/loginSuccess")
    public String loginSuccess(HttpSession session){
        session.setAttribute("visited", true);
        return "/dashboard";
    }
}
