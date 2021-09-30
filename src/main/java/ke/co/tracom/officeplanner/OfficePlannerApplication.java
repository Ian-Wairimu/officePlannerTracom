package ke.co.tracom.officeplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OfficePlannerApplication {
    @RequestMapping("/")
    String home(){
        return "hello, there";
    }
    public static void main(String[] args) {
        SpringApplication.run(OfficePlannerApplication.class, args);
       
    }

}
