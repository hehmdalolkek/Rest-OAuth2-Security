package ru.hehmdalolkek.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hehmdalolkek.restapi.dao.CarDao;
import ru.hehmdalolkek.restapi.model.Car;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Override
    public Iterable<Car> getCars() {
        return this.carDao.findAll();
    }

    @Override
    public Car createCar(Car car) {
        return this.carDao.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        this.carDao.deleteById(id);
    }

}
