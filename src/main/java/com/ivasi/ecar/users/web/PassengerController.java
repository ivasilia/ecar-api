package com.ivasi.ecar.users.web;

import com.ivasi.ecar.users.models.Driver;
import com.ivasi.ecar.users.models.Passenger;
import com.ivasi.ecar.users.service.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/passengers")
@CrossOrigin
public class PassengerController {
    private final PassengersService passengersService;

    @Autowired
    public PassengerController(PassengersService passengersService) {
        this.passengersService = passengersService;
    }

    @GetMapping("/all")
    public Collection<Passenger> getAll() {
        return this.passengersService.getAll();
    }

    @GetMapping("/{id}")
    public Passenger getByUserId(@PathVariable("id") String id) {
        return this.passengersService.getByUserId(id);
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("imageUrl") String imageUrl) {
        return this.passengersService.register(username, password, imageUrl);
    }
}
