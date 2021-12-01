package ke.co.tracom.officeplanner.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.concurrent.TimeUnit;

public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/script/**", "/img/**", "/icon/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**/*.js", "/**/*.css", "/home/**", "/register").permitAll()
//                .antMatchers("/api/**").hasRole(STUDENT.name())
//                .antMatchers(HttpMethod.DELETE, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
//                .antMatchers(HttpMethod.POST, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
//                .antMatchers(HttpMethod.PUT, "management/api/**").hasAuthority(USER_WRITE.getAuthentication())
//                .antMatchers(HttpMethod.GET, "management/api/**").hasAnyRole(ADMIN.name(), STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                //login
                .formLogin().disable()
//                .loginPage("/loginPage").permitAll()
//                .passwordParameter("password")
//                .usernameParameter("parameter")
//                .defaultSuccessUrl("/view", true)
                //remember me
                .rememberMe()//valid to 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .key("something very secured")
                .rememberMeParameter("remember-me")
                //logout
                .and()
                .logout() //REQUEST MUST BE A POST WHEN CSRT IS ENABLED
//                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("", "");
//                .logoutSuccessUrl("/home");

    }
}
