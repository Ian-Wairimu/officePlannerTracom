package ke.co.tracom.officeplanner.controller;

import ke.co.tracom.officeplanner.user.User;
import ke.co.tracom.officeplanner.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("")
    public String IndexViewPage(User user){
        return "index";
    }

}
