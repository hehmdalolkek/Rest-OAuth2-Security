package ru.hehmdalolkek.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hehmdalolkek.client.model.Car;
import ru.hehmdalolkek.client.service.CarService;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public String cars(Model model) {
        Iterable<Car> cars = this.carService.getCars();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @PostMapping("/cars/delete")
    public String cars(long id) {
        this.carService.deleteCarById(id);
        return "redirect:/cars";
    }

}
