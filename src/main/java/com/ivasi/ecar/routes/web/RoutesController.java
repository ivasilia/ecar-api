package com.ivasi.ecar.routes.web;

import com.ivasi.ecar.routes.service.GasStation;
import com.ivasi.ecar.routes.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuel")
public class RoutesController {
    private final RoutesService routesService;

    @Autowired
    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping("/{routeId}")
    public GasStation getFuelPrice(@PathVariable("routeId") String routeId) {
        System.out.println(this.routesService.calculateTotalFuel(routeId));
        // TODO initialize the Route or make an on-the-fly Route
        return this.routesService.getCurrentFuelPrice();
    }
}
