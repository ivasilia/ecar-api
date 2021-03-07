package com.ivasi.ecar.init;

import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public DataInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Initialize sample Users

//        UserEntity user1 = new UserEntity("Elizabeth of England", "1234", "eli@england.co.uk");
//        UserEntity user2 = new UserEntity("Till Eulenspiegel", "1234", "till@tales.com");
//        UserEntity user3 = new UserEntity("Ibn Sina", "1234", "sina@persia.org");

        this.userService.initializeUsers();

    }
}
