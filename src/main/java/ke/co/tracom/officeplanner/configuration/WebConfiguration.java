package ke.co.tracom.officeplanner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //help us to use the preauthorized command
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "index", "static/css/**", "static/js/**", "static/images/**" ).permitAll()
                .and()
                //login
                .formLogin()
//                .loginPage("/login").permitAll()
                .passwordParameter("password")
                .usernameParameter("parameter")
                .defaultSuccessUrl("/home", true)
                .and()
                //remember me
                .rememberMe()//valid to 2 weeks
                .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                .key("something very secured")
                .rememberMeParameter("remember-me")
                //logout
                .and()
                .logout() //REQUEST MUST BE A POST WHEN CSRT IS ENABLED
//                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("", "")
                .logoutSuccessUrl("/home");
    }
}
