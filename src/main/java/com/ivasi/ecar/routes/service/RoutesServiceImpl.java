package com.ivasi.ecar.routes.service;

import com.ivasi.ecar.routes.repo.RoutesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        return Double.parseDouble(
                this.routesRepo.findById(routeId).orElse(null)
                        .getDistance()) * GasStation.getDiesel();
    }


}
