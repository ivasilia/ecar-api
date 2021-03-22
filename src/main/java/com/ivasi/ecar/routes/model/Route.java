package com.ivasi.ecar.routes.model;

import com.ivasi.ecar.routes.service.GasStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String id;
    private String origin;
    private String destination;
    private String distance;
    private double fuelPrice;
    private int passengersCount;

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = GasStation.getDiesel();
    }
}
