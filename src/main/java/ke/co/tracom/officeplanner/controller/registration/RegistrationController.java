package ke.co.tracom.officeplanner.controller.registration;

import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(final Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registerUser(final @Valid @ModelAttribute("user") User user, final BindingResult result, String siteUrl)throws UnsupportedEncodingException, MessagingException {
        userService.registerUser(user, siteUrl);
//        if (result.hasErrors()) {
//            return "registration";
//        }
        return "index";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/process_register")
    public String processRegister(User user, HttpServletRequest request)throws UnsupportedEncodingException, MessagingException{
        userService.registerUser(user, getSiteUrl(request));

        return "register_success";
    }
    private String getSiteUrl(HttpServletRequest request) {
        String siteUrl = request.getRequestURL().toString();
        return siteUrl.replace(request.getServletPath(), "");
    }
    @RequestMapping(method = RequestMethod.GET, value = "/verify")
    public String verifyUser(@Param("code") String verificationCode){
        if (userService.verify(verificationCode)){
            return "verify_success";
        }
        else {
            return "verify_fail";
        }
    }
}
