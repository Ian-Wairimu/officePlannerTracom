package ke.co.tracom.officeplanner.controller.registration;


import ke.co.tracom.officeplanner.entity.token.ConfirmationToken;
import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.ConfirmationTokenRepository;
import ke.co.tracom.officeplanner.repository.UserRepository;
import ke.co.tracom.officeplanner.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private UserRepository userRepository;
    private ConfirmationTokenRepository confirmationTokenRepository;
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") User user, ModelAndView modelAndView){
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email does not exist");
            modelAndView.setViewName("error");
        }
        else{
            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken();
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Verify Registration");
            mailMessage.setFrom("wairimuianmoon@gmail.com");
            mailMessage.setText("To confirm your account and set password, please click here :"
            +"http://localhost:8080/confirm-set?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
            modelAndView.addObject("password", "Check email for link to set password");
            modelAndView.setViewName("registration-success");
        }
        return modelAndView;
    }
    @RequestMapping(value ="/confirm-set", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            User user = userRepository.findByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else{
            modelAndView.addObject("message", "the link is invalid or broken");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/set-password", method = RequestMethod.POST)
    public ModelAndView setPassword(ModelAndView modelAndView, @ModelAttribute("user") User user){
        if (user.getEmail() != null) {
            User tokenUser =userRepository.findByEmail(user.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encoder = passwordEncoder.encode(user.getPassword());
            tokenUser.setPassword(encoder);
            userRepository.save(tokenUser);
            modelAndView.addObject("message", "password successfully set. you can now login with credentials");
            modelAndView.setViewName("successPasswordSet");
        }
        else {
            modelAndView.addObject("message", "the link is invalid or broken");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
