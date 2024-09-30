package com.robomech.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.robomech.weather.model.Response;

@RestController
public class WeatherController {
    private static final String API_KEY = "516dc88f3cf8bed96031862084735caf";
    
        @GetMapping("/test")
        public String test()
        {
            return "Ayush Srivastava Microservice up";
        }
    
        @GetMapping("/getWeather/lat={lat}&lon={lon}")
        public Response getWeather(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
            ResponseEntity<Response> response = new RestTemplate().getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+API_KEY,
        Response.class);

        return response.getBody();
    }

}

