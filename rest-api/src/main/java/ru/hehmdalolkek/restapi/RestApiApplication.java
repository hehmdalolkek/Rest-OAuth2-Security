package ru.hehmdalolkek.restapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.hehmdalolkek.restapi.dao.CarDao;
import ru.hehmdalolkek.restapi.model.Car;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(CarDao carDao) {
        return args -> {
            carDao.save(
                    new Car(1L, "BMW", "X5", "black"));
            carDao.save(
                    new Car(2L, "Audi", "Q3", "red"));
        };
    }

}
