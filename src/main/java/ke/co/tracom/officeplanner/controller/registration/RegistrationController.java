package ke.co.tracom.officeplanner.controller.registration;

import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserRepository repository;
    @Autowired
    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(final Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registerUser(final @Valid @ModelAttribute("user") User user, final BindingResult result){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repository.save(user);

        if (result.hasErrors()) {
            return "registration";
        }
        return "index";
    }
}
