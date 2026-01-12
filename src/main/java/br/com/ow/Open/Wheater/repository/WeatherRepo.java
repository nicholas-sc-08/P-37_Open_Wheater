package br.com.ow.Open.Wheater.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ow.Open.Wheater.model.Weather;

public interface WeatherRepo extends CrudRepository<Weather, Integer>{
    public Weather findByName(String name);
}
