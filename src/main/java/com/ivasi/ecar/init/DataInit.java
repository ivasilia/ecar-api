package com.ivasi.ecar.init;

import com.ivasi.ecar.routes.service.RoutesService;
import com.ivasi.ecar.users.service.DriversService;
import com.ivasi.ecar.users.service.UserService;
import com.ivasi.ecar.vehicles.service.ECarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;
    private final DriversService driversService;
    private final ECarsService eCarsService;
    private final RoutesService routesService;

    @Autowired
    public DataInit(UserService userService, DriversService driversService, ECarsService eCarsService, RoutesService routesService) {
        this.userService = userService;
        this.driversService = driversService;
        this.eCarsService = eCarsService;
        this.routesService = routesService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.userService.initializeUsers();
        this.driversService.initializeDrivers();
        this.routesService.initializeRoutes();

    }
}
