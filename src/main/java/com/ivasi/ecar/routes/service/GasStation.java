package com.ivasi.ecar.routes.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public abstract class GasStation implements Serializable {
    @JsonProperty
    private String name;
    @JsonProperty
    private String place;
    @JsonProperty
    private double e5;
    @JsonProperty
    private double e10;
    @JsonProperty
    static double diesel;

    public static double getDiesel() {
        return diesel;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("station")
    private void unpackPrices(Map<String, Object> station) {
        this.name = (String) station.get("name");
        this.place = (String) station.get("place");
        this.e5 = (double) station.get("e5");
        this.e10 = (double) station.get("e10");
        this.diesel = (double) station.get("diesel");
    }
}
