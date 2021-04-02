package com.ivasi.ecar.routes.web;

import com.ivasi.ecar.routes.gmaps.GoogleMapsHandler;
import com.ivasi.ecar.routes.model.Route;
import com.ivasi.ecar.routes.service.GasStation;
import com.ivasi.ecar.routes.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/routes")
@CrossOrigin(origins = "http://localhost:3000")
public class RoutesController {
    private final RoutesService routesService;
    private final GoogleMapsHandler googleMapsHandler;

    @Autowired
    public RoutesController(RoutesService routesService, GoogleMapsHandler googleMapsHandler) {
        this.routesService = routesService;
        this.googleMapsHandler = googleMapsHandler;
    }

    @GetMapping("/fuel-price/{routeId}")
    public GasStation getFuelPrice(@PathVariable("routeId") String routeId) {
        System.out.println(this.routesService.calculateTotalFuel(routeId));
        // TODO initialize the Route or make an on-the-fly Route
        return this.routesService.getCurrentFuelPrice();
    }

    @GetMapping("/all")
    public Collection<Route> getAll() {
        return this.routesService.getAll();
    }

    @PostMapping("/create")
    public String createRoute(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("distance") double distance
            ) {
        return this.routesService.createRoute(origin, destination, distance);
    }
}
