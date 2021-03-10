package com.ivasi.ecar.vehicles.models.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECarExportDto {
    private String id;
    private String model;
    private double mileageCharged;
}
