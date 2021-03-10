package com.ivasi.ecar.users.service.impl;

import com.ivasi.ecar.users.models.AuthorityEntity;
import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.repo.UserRepo;
import com.ivasi.ecar.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }


    @Override
    public void initializeUsers() {
        if (this.userRepo.findAll().size() == 0) {
            // Set initial USER
            UserEntity user = new UserEntity();
            user.setUsername("oswald");
            user.setPassword(this.encoder.encode("oswald"));
            user.setActive(true);
            user.setEmail("ossi@ossi.os");
            user.setFirstName("Oswald");
            user.setLastName("Oost");

            AuthorityEntity authority = new AuthorityEntity();
            authority.setName("ROLE_USER");
            authority.setUser(user);

            user.setAuthorities(List.of(authority));
            this.userRepo.save(user);

            // Set ADMIN
            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setPassword(this.encoder.encode("admin"));
            admin.setActive(true);

            AuthorityEntity adminUserAuthority = new AuthorityEntity();
            adminUserAuthority.setName("ROLE_USER");
            adminUserAuthority.setUser(admin);

            AuthorityEntity adminAdminAuthority = new AuthorityEntity();
            adminAdminAuthority.setName("ROLE_ADMIN");
            adminAdminAuthority.setUser(admin);

            admin.setAuthorities(List.of(adminUserAuthority, adminAdminAuthority));
            this.userRepo.save(admin);
        }
    }


    @Override
    public UserEntity getUserByUsername(String username) {
        return this.userRepo.findByUsername(username).orElse(null);
    }

}
