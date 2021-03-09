package com.ivasi.ecar.users.web;

import com.ivasi.ecar.users.models.Credentials;
import com.ivasi.ecar.users.models.JwtResponse;
import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.services.UserService;
import com.ivasi.ecar.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<JwtResponse> login(@RequestBody Credentials credentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        final UserEntity user = userService
                .getUserByUsername(credentials.getUsername());
        final String token = jwtUtils.generateToken(user);
        log.info("Login successful for {}: {}", user.getUsername(), token);
        return ResponseEntity.ok(new JwtResponse(token, user));
    }
}
