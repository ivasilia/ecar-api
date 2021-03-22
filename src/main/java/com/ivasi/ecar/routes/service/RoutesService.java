package com.ivasi.ecar.routes.service;

public interface RoutesService {
    GasStation getCurrentFuelPrice();
    Double calculateTotalFuel(String routeId);
}
