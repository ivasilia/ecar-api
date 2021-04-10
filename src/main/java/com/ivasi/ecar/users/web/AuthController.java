package com.ivasi.ecar.users.web;

import com.ivasi.ecar.users.models.Credentials;
import com.ivasi.ecar.users.models.JwtResponse;
import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.service.UserService;
import com.ivasi.ecar.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Profiles;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
@Slf4j
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    public ResponseEntity<JwtResponse> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
//            HttpServletResponse response
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        final UserEntity user = userService
                .getUserByUsername(username);
        final String token = jwtUtils.generateToken(user);
        log.info("Login successful for {}: {}", user.getUsername(), token);

//        Cookie cookie = new Cookie("jwt", token);
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(1000);
//        response.addCookie(cookie);
        return ResponseEntity.ok()
//                .header(HttpHeaders.WWW_AUTHENTICATE, cookie.toString())
                .body(new JwtResponse(token, user));
    }
}
