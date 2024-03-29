package com.ivasi.ecar.routes.service;

import com.ivasi.ecar.routes.model.Route;

import java.util.Collection;

public interface RoutesService {
    GasStation getCurrentFuelPrice();
    Double calculateTotalFuel(String routeId);

    String createRoute(String origin, String destination, double distance, String driverId);

    Collection<Route> getAll();

    void initializeRoutes();

    Route getById(String id);

    int addPassengerToRoute(String routeId, String passengerId);
}
