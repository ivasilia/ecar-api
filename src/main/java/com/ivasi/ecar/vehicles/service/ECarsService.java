package com.ivasi.ecar.vehicles.service;

import com.ivasi.ecar.vehicles.models.ECar;
import com.ivasi.ecar.vehicles.models.dto.ECarExportDto;

import java.util.Collection;

public interface ECarsService {
    ECar create(ECar body);

    Collection<ECarExportDto> getAll();
}
