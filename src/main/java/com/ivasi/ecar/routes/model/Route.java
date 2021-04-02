package com.ivasi.ecar.routes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivasi.ecar.routes.service.GasStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @NonNull
    @JsonProperty
    private String id;
    @NonNull
    private String origin;
    @NonNull
    private String destination;
    private double distance;
    private double fuelPrice;
    private int passengersCount;

    public Route(String origin, String destination, double distance) {

        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.setFuelPrice();
    }

    public void setFuelPrice() {
        this.fuelPrice = GasStation.getDiesel();
    }
}
