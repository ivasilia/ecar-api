package com.ivasi.ecar.routes.repo;

import com.ivasi.ecar.routes.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoutesRepo extends JpaRepository<String, Route> {
    Optional<Route> findById(String routeId);
}
