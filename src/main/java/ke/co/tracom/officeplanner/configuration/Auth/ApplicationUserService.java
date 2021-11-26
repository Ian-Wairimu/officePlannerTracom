//package ke.co.tracom.officeplanner.configuration.Auth;
//
//import ke.co.tracom.officeplanner.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ApplicationUserService implements UserDetailsService {
//    private final UserRepository userRepository;
//    @Autowired
//    public ApplicationUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (UserDetails) userRepository
//                .selectApplicationUserByUsername(username)
//                .orElseThrow(
//                        () -> new UsernameNotFoundException(String.format("Username %s not found", username))
//                );
//    }
//}
