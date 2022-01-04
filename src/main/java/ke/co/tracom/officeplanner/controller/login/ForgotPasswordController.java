package ke.co.tracom.officeplanner.controller.login;

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
public class ForgotPasswordController {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;
    @Autowired
    public ForgotPasswordController(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
    }
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword(Model model){
        model.addAttribute("user", new User());
        return "forgot-password";
    }
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String forgotUserPassword(Model model, @ModelAttribute("user") User user){
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(existingUser.getEmail());
            mailMessage.setSubject("Complete password reset");
            mailMessage.setFrom("wairimuianmoon@gmail.com");
            mailMessage.setText("To complete password reset process, please click here:"+
                    "http://localhost:8080/confirm-password-reset?token="+
                    confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            model.addAttribute("message", "Request to reset password received. check your inbox for the reset link.");

            return "success-forgot-password";
        }
        else {
            model.addAttribute("message", "this email already exists");
            return "error";
        }
    }
    @RequestMapping(value = "/confirm-password-reset", method = {RequestMethod.GET, RequestMethod.POST})
    public String validateResetToken(@RequestParam("token") String confirmationToken, Model model){

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            model.addAttribute("user", user);
            model.addAttribute("email", user.getEmail());
            return "reset-password";
        }
        else {
            model.addAttribute("message", "this is a broken link");
            return "error";
        }
    }
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String resetUserPassword(Model model, @ModelAttribute("user") User user){
        if (user.getEmail() != null) {
            User tokenUser = userRepository.findByEmail(user.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            String encoder = passwordEncoder.encode(user.getPassword());
            tokenUser.setPassword(encoder);
            model.addAttribute("message", "Password successfully reset. You can now log in with new credentials.");
            return "success-password-reset";
        }
        else{
            model.addAttribute("message", "this is a broken link");
            return "error";
        }
    }
}
