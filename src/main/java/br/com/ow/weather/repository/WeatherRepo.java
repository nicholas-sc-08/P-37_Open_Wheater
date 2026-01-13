package br.com.ow.weather.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ow.weather.model.Weather;

@Repository
public interface WeatherRepo extends CrudRepository<Weather, Integer>{
    public Weather findByName(String name);
}
