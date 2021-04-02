package com.ivasi.ecar.routes.service;

import com.ivasi.ecar.routes.model.Route;

import java.util.Collection;

public interface RoutesService {
    GasStation getCurrentFuelPrice();
    Double calculateTotalFuel(String routeId);

    String createRoute(String origin, String destination, double distance);

    Collection<Route> getAll();

    void initializeRoutes();
}
