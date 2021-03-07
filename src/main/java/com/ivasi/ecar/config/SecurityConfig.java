package com.ivasi.ecar.config;

import com.ivasi.ecar.security.CurrentUserDetailsService;
import com.ivasi.ecar.security.CustomSuccessHandler;
import com.ivasi.ecar.users.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.persistence.EntityNotFoundException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)    //  @PreAuthorize etc..
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CurrentUserDetailsService userDetailsService;
    private final CustomSuccessHandler authSuccessHandler;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder,
                          CurrentUserDetailsService userDetailsService,
                          CustomSuccessHandler authSuccessHandler) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authSuccessHandler = authSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(this.userDetailsService).
                passwordEncoder(this.passwordEncoder);
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeRequests().
                antMatchers("/**").permitAll().
//                antMatchers("/", "/login", "/register").permitAll().
                antMatchers("/admin/**").hasRole("ADMIN").
                antMatchers("/user/**").hasRole("USER").
                antMatchers("/assistant/**").hasRole("ASSISTANT").
                and().
                headers().frameOptions().disable(). // ---- For H2 !!! ----
                and().
                formLogin().
                loginPage("/login").permitAll().
                loginProcessingUrl("/login").
                failureForwardUrl("/login-error").
                successForwardUrl("/index").
                defaultSuccessUrl("/").
//        successHandler(authSuccessHandler).
//                usernameParameter("username").
//                passwordParameter("password").
                and().
                logout().
                logoutRequestMatcher(new AntPathRequestMatcher("/_leaving")).
//                logoutUrl("/_leaving").
        logoutSuccessUrl("/").
                invalidateHttpSession(true).
                deleteCookies("JSESSIONID").
                and().
                csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return username -> {
            try {
                UserDetails found = userService.getUserByUsername(username);
                log.debug(">>> User authenticated for username: {} is {}", username, found);
                return found;
            } catch (EntityNotFoundException ex) {
                throw new UsernameNotFoundException(ex.getMessage(), ex);
            }
        };
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

