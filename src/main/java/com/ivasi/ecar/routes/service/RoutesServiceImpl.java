package com.ivasi.ecar.routes.service;

import com.ivasi.ecar.routes.model.Route;
import com.ivasi.ecar.routes.repo.RoutesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class RoutesServiceImpl implements RoutesService {
    private final String FUEL_PRICE_URL =
            "https://creativecommons.tankerkoenig.de/json/detail.php?id=005056ba-7cb6-1ed2-bceb-90e59ad2cd35&apikey=5806097d-91f5-1ba8-62ea-a59cabb8b7c5";
    private final String FUEL_PRICE_API_KEY = "5806097d-91f5-1ba8-62ea-a59cabb8b7c5";
    private final RoutesRepo routesRepo;

    @Autowired
    public RoutesServiceImpl(RoutesRepo routesRepo) {
        this.routesRepo = routesRepo;
    }

    @Override
    public GasStation getCurrentFuelPrice() {
        RestTemplate restTemplate = new RestTemplate();
        GasStation response
                = restTemplate.getForObject(FUEL_PRICE_URL, GasStation.class);
        return response;
    }

    @Override
    public Double calculateTotalFuel(String routeId) {
        return this.routesRepo.findById(routeId).orElse(null)
                        .getDistance() * GasStation.getDiesel();
    }

    @Override
    public String createRoute(String origin, String destination, double distance, String driverId) {
        System.out.println("Here RoutesService: " + origin);
        Route newRoute = new Route(origin, destination, distance, driverId);
        return this.routesRepo.saveAndFlush(newRoute).getId();   // ---- return ID of create Route ----
    }

    @Override
    public Collection<Route> getAll() {
        return this.routesRepo.findAll();
    }

    @Override
    public void initializeRoutes() {
        if(this.routesRepo.count() == 0) {
            Route route66 = new Route("Klagenfurt", "Salzburg", 202.8634, "admin");
            this.routesRepo.save(route66);
        }
    }

    @Override
    public Route getById(String id) {
        return this.routesRepo.findById(id).orElse(null);
    }

    @Override
    public int addPassengerToRoute(String routeId, String passengerId) {
        // --- For now just increasing the number of passengers ----
        Route route = this.routesRepo.findById(routeId).orElse(null);
        route.setPassengersCount(route.getPassengersCount() + 1);
        this.routesRepo.saveAndFlush(route);
        return route.getPassengersCount();
    }

}
