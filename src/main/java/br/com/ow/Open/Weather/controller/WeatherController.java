package br.com.ow.Open.Weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ow.Open.Weather.model.Weather;
import br.com.ow.Open.Weather.service.WeatherService;

@RestController
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<List<Weather>> getAllWeathers() {
        return ResponseEntity.ok().body(weatherService.getAllWeathers());
    }

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
