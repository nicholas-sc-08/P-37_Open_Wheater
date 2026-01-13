package br.com.ow.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ow.weather.model.Weather;
import br.com.ow.weather.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Weather Endpoint", description = "Return the climate of cities or states.")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;

    @Operation(summary = "Get all the weathers of cities or states saved in the table weather.")
    @GetMapping("/weather")
    public ResponseEntity<List<Weather>> getAllWeathers() {
        return ResponseEntity.ok().body(weatherService.getAllWeathers());
    }

    @Operation(summary = "Get specific weather information for a city and save it in the database.")
    @GetMapping("/weather/{name}")
    public ResponseEntity<?> getWeatherByName(@PathVariable String name) {
        try {
            
            Weather weather = weatherService.getWeatherByName(name);
            if(weather != null) {
                return ResponseEntity.ok().body(weather);
            }
            return ResponseEntity.status(404).body("City "+ name +" not found!");

        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}

