package ke.co.tracom.officeplanner.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    private final Logger LOGGER = LoggerFactory.getLogger(User.class);
//
//        LOGGER.info("inside department controller");
    @GetMapping("/index")
    public String home(){
        return "index";
    }

}
