package ke.co.tracom.officeplanner.service;

import ke.co.tracom.officeplanner.entity.user.User;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public interface UserService {

    void registerUser(User user, String siteUrl) throws UnsupportedEncodingException, MessagingException;

    boolean verify(String verificationCode);
}
