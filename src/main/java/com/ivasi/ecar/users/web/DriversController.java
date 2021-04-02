package com.ivasi.ecar.users.web;

import com.ivasi.ecar.users.models.Driver;
import com.ivasi.ecar.users.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
@CrossOrigin(origins = "http://localhost:3000")
public class DriversController {
    private final DriversService driversService;

    @Autowired
    public DriversController(DriversService driversService) {
        this.driversService = driversService;
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable("id") String id) {
        return this.driversService.getById(id);
    }

}
