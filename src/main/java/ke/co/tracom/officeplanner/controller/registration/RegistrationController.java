package ke.co.tracom.officeplanner.controller.registration;


import ke.co.tracom.officeplanner.entity.token.ConfirmationToken;
import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.ConfirmationTokenRepository;
import ke.co.tracom.officeplanner.repository.UserRepository;
import ke.co.tracom.officeplanner.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;
    @Autowired
    public RegistrationController(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, Model model){
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            model.addAttribute("message", "this email already exists");
            return "error";
        }
        else{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            String encoder = passwordEncoder.encode(user.getPassword());
            user.setPassword(encoder);

            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration");
            mailMessage.setFrom("wairimuianmoon@gmail.com");
            mailMessage.setText("To confirm your account, please click here:"+
                    "http://localhost:8080/confirm-account?token="+
                    confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            model.addAttribute("emailId", user.getEmail());

            return "registration-success";

        }
    }
    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token") String confirmationToken, Model model){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            User user = userRepository.findByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            return "login-page";
        }
        else {
            model.addAttribute("message", "this is a broken link");
            return "error";
        }
    }
}
