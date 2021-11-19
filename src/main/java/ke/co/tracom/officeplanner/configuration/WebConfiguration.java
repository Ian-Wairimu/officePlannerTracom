package ke.co.tracom.officeplanner.configuration;

import ke.co.tracom.officeplanner.configuration.Auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

import static ke.co.tracom.officeplanner.configuration.AppUserAuth.USER_WRITE;
import static ke.co.tracom.officeplanner.configuration.AppUserRole.ADMIN;
import static ke.co.tracom.officeplanner.configuration.AppUserRole.STUDENT;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //help us to use the preauthorized command
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    @Autowired
    public WebConfiguration (PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService){
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
                .antMatchers(HttpMethod.POST, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
                .antMatchers(HttpMethod.PUT, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
                .antMatchers(HttpMethod.GET, "management/api/**").hasAnyRole(ADMIN.name(), STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                //login
                .formLogin()
//                .loginPage().permitAll()
                .passwordParameter("password")
                .usernameParameter("parameter")
                .defaultSuccessUrl("/index", true)
                .and()
                //remember me
                .rememberMe()//valid to 2 weeks
                .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                .key("something very secured")
                .rememberMeParameter("remember-me")
                //logout
                .and()
                .logout() //REQUEST MUST BE A POST WHEN CSRT IS ENABLED
//                .logoutUrl()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("", "");
//                .logoutSuccessUrl();
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails wairimuUser = User.builder()
//                .username("ian")
//                .password(passwordEncoder.encode("wairimuian369"))
//                .authorities(STUDENT.getGrantedAuthorities())
//                .roles(STUDENT.name()) //roles admin
//                .build();
//        return new InMemoryUserDetailsManager(
//                wairimuUser
//        );
//    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }
}
