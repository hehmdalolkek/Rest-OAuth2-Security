package ru.hehmdalolkek.restapi.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hehmdalolkek.restapi.model.Car;
import ru.hehmdalolkek.restapi.service.CarService;

@RestController
@RequestMapping(path = "/api/v1/car", produces = "application/json")
@CrossOrigin(origins = "${client.url}")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public Iterable<Car> getCars() {
        return this.carService.getCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        return this.carService.createCar(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") Long id) {
        this.carService.deleteCar(id);
    }

}
