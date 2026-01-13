package br.com.ow.Open.Weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ow.Open.Weather.dto.WeatherDTO;
import br.com.ow.Open.Weather.model.Weather;
import br.com.ow.Open.Weather.repository.WeatherRepo;

@Service
public class WeatherService {
    
    @Autowired
    private WeatherRepo weatherRepo;
    private RestTemplate restTemplate;

    @Value("${openweather.api.key}")
    private String apiKey;

    public List<Weather> getAllWeathers() {
        return (List<Weather>) weatherRepo.findAll();
    };

    public Weather getWeatherByName(String name) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + apiKey + "&units=metric&lang=pt-br";
            
            restTemplate = new RestTemplate();
            WeatherDTO weather = restTemplate.getForObject(url, WeatherDTO.class);
            
            Weather res = new Weather();
            res.setName(weather.getName());
            res.setMain(weather.getWeather().get(0).getMain());
            res.setDescription(weather.getWeather().get(0).getDescription());
            res.setIcon(weather.getWeather().get(0).getIcon());
            res.setTemp(weather.getMain().getTemp());
            res.setHumidity(weather.getMain().getHumidity());
            res.setWindSpeed(weather.getWind().getSpeed());
        
            return weatherRepo.save(res);
    
        } catch (Exception e) {
            return null;
        }
    } 
}
