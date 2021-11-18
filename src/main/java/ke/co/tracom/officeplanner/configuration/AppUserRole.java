package ke.co.tracom.officeplanner.configuration;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ke.co.tracom.officeplanner.configuration.AppUserAuth.USER_READ;
import static ke.co.tracom.officeplanner.configuration.AppUserAuth.USER_WRITE;

public enum AppUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE));

    private final Set<AppUserAuth> auths;

    AppUserRole(Set<AppUserAuth> auths) {
        this.auths = auths;
    }

    public Set<AppUserAuth> getAuths() {
        return auths;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority>  authentications = getAuths().stream()
                .map(authentication -> new  SimpleGrantedAuthority(authentication.getAuthentication()))
                .collect(Collectors.toSet());
        authentications.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authentications;
    }
}
