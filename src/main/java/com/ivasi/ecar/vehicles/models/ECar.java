package com.ivasi.ecar.vehicles.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Duration;

@Entity
@Table(name = "e_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECar {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotNull
    private String model;
    private double mileageCharged;
//    private Duration chargeTime;

    public ECar(String model, double mileageCharged) {
        this.model = model;
        this.mileageCharged = mileageCharged;
//        this.chargeTime = chargeTime;
    }
}