package com.ivasi.ecar.vehicles.service.impl;

import com.ivasi.ecar.vehicles.models.ECar;
import com.ivasi.ecar.vehicles.models.dto.ECarExportDto;
import com.ivasi.ecar.vehicles.repo.ECarsRepo;
import com.ivasi.ecar.vehicles.service.ECarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ECarsServiceImpl implements ECarsService {
    private final ECarsRepo eCarsRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ECarsServiceImpl(ECarsRepo eCarsRepo, ModelMapper modelMapper) {
        this.eCarsRepo = eCarsRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public ECar create(ECar body) {
        ECar eCar = new ECar(body.getModel(), body.getMileageCharged()
//                body.getChargeTime()
        );

        return this.eCarsRepo.save(eCar);
    }

    @Override
    public Collection<ECarExportDto> getAll() {
        return this.eCarsRepo.findAll().stream()
                .map(ecar -> this.modelMapper.map(ecar, ECarExportDto.class))
                .collect(Collectors.toList());
    }
}
