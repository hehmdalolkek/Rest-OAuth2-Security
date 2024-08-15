package ru.hehmdalolkek.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.hehmdalolkek.restapi.model.Car;

public interface CarDao extends CrudRepository<Car, Long> {
}
