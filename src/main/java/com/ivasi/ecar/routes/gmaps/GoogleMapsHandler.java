package com.ivasi.ecar.routes.gmaps;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import org.springframework.stereotype.Component;

@Component
public class GoogleMapsHandler {

        public static DistanceMatrixApiRequest getDistanceMatrix(
            GeoApiContext context, String[] origins, String[] destinations) {
        return null;
    }
}
