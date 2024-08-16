package ru.hehmdalolkek.client.service;

import ru.hehmdalolkek.client.model.Car;

public interface CarService {

    Iterable<Car> getCars();

    Car createCar(Car car);

    void deleteCarById(long id);

}
