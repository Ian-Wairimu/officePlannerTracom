package ke.co.tracom.officeplanner.service.impl;

import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.UserRepository;
import ke.co.tracom.officeplanner.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;
    private JavaMailSender mailSender;
    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, JavaMailSender mailSender) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
    }

    @Override
    public void registerUser(User user, String siteUrl)throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        repository.save(user);

        sendVerificationEmail(user, siteUrl);
    }

    private void sendVerificationEmail(User user, String siteUrl)throws UnsupportedEncodingException, MessagingException{
        String toAddress = user.getEmail();
        String fromAddress = "wairimuianmoon@gmail.com";
        String senderName = "Tracom";
        String subject = "please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[URL]]", user.getEmail());
        String verifyUrl = siteUrl + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyUrl);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public boolean verify(String verificationCode) {
        User user = repository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        }else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            repository.save(user);

            return true;
        }
    }
}
