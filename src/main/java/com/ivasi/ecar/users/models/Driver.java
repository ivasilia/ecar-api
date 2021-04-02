package com.ivasi.ecar.users.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivasi.ecar.vehicles.models.ECar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @NonNull
    @JsonProperty
    private String model;
    @NonNull
    @JsonProperty
    private String fuel;
    @NonNull
    @JsonProperty
    private double consumption;
//    @JsonProperty
//    @ManyToOne
//    private ECar car;


    public Driver(String name, String model, String fuel, double consumption) {
        this.name = name;
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
    }
}
