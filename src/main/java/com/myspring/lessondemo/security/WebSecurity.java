package com.myspring.lessondemo.security;

import com.myspring.lessondemo.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userDetailsSevice;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public WebSecurity(UserService userSevice, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsSevice = userSevice;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users").permitAll().anyRequest().authenticated()
        .and().addFilter(getAuthentificationFilter()).addFilter(new AuthorizationFilter(authenticationManager()));
    }

    //protect user password
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
       auth.userDetailsService(userDetailsSevice) .passwordEncoder(bCryptPasswordEncoder);
    }

    public AuthenticationFilter getAuthentificationFilter() throws Exception{
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/users/login");
        return filter;
    }

}
