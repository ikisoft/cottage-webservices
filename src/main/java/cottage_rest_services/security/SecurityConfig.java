package cottage_rest_services.security;

import cottage_rest_services.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by maxikahe on 27.5.2017.
 */


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DetailsService detailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(User.PASSWORD_ENCODER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/cottage").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/user").authenticated()
                .antMatchers(HttpMethod.DELETE,"/api/user").authenticated()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.GET,"/api/user").authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}






