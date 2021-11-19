package ke.co.tracom.officeplanner.controller.login;

import ke.co.tracom.officeplanner.domain.user.User;
import ke.co.tracom.officeplanner.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping("/login")
    @ResponseBody
    public String loginPage(@ModelAttribute("user") User user, Model model){
        return this.loginService.loginPage(user);
    }
}
