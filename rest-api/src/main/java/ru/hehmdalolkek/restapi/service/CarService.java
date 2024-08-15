package ru.hehmdalolkek.restapi.service;

import ru.hehmdalolkek.restapi.model.Car;

public interface CarService {

    Iterable<Car> getCars();

    Car createCar(Car car);

    void deleteCar(Long id);

}
