package com.ivasi.ecar.routes.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MapsController {

    private String distanceMatrixApiKey = "AIzaSyDHDbORUyOSxRBZj9flx736bV7mrqglhBM";

    @GetMapping("/routes/distance")
    public String getDistance(@RequestParam(name = "origin", required = true) String from,
                              @RequestParam(name = "destination", required = true) String to) {

        return callAndParse("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + from
                + "&destinations=" + to + "&key=" + distanceMatrixApiKey).toString();

    }

    private String callAndParse(String endpoint) {
        URL url;
        try {
            url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}
