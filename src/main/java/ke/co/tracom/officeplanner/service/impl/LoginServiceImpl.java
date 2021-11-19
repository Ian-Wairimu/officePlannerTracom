package ke.co.tracom.officeplanner.service.impl;

import ke.co.tracom.officeplanner.domain.user.User;
import ke.co.tracom.officeplanner.repository.UserRepository;
import ke.co.tracom.officeplanner.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
   @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String loginPage(User user) {
        return this.userRepository.findUserByEmail();
    }
}
