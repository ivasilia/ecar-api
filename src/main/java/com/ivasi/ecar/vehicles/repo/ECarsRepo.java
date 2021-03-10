package com.ivasi.ecar.vehicles.repo;

import com.ivasi.ecar.vehicles.models.ECar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECarsRepo extends JpaRepository<ECar, String> {
}
