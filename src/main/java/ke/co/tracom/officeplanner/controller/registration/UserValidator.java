package ke.co.tracom.officeplanner.controller.registration;

import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserRepository userRepository;
    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String email = user.getEmail();
        User userByEmail = userRepository.findByEmail(email);
        if (userByEmail != null) {
            errors.rejectValue("email",
                    "email.exists",
                    new Object[]{email},
                    "Email " + email + " already in use");
        }
    }
}
