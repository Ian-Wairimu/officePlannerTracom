package ke.co.tracom.officeplanner.configuration.Auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static ke.co.tracom.officeplanner.configuration.AppUserRole.STUDENT;

@Repository("fake")
public class ApplicationUserDaoImpl implements ApplicationUserDao{
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUsers -> username.equals(applicationUsers.getUsername()))
                .findFirst();
    }
    private List<ApplicationUser> getApplicationUsers(){
     List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    STUDENT.getGrantedAuthorities(),
                    passwordEncoder.encode("wairimu"),
                    "moon",
                    true,
                    true,
                    true,
                    true
            )
    );
    return applicationUsers;
}
}
