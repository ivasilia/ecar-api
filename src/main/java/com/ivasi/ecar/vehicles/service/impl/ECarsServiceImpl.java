package com.ivasi.ecar.vehicles.service.impl;

import com.ivasi.ecar.vehicles.models.ECar;
import com.ivasi.ecar.vehicles.repo.ECarsRepo;
import com.ivasi.ecar.vehicles.service.ECarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ECarsServiceImpl implements ECarsService {
    private final ECarsRepo eCarsRepo;

    @Autowired
    public ECarsServiceImpl(ECarsRepo eCarsRepo) {
        this.eCarsRepo = eCarsRepo;
    }


    @Override
    public ECar create(ECar body) {
        ECar eCar = new ECar(body.getModel(), body.getMileageCharged()
//                body.getChargeTime()
        );

        return this.eCarsRepo.save(eCar);
    }
}
