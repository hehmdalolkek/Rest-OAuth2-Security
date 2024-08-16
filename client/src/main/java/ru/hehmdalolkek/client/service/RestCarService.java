package ru.hehmdalolkek.client.service;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import ru.hehmdalolkek.client.model.Car;

import java.util.List;
import java.util.Objects;

public class RestCarService implements CarService {

    private RestTemplate restTemplate;

    public RestCarService(String accessToken) {
        this.restTemplate = new RestTemplate();
        if (Objects.nonNull(accessToken)) {
            this.restTemplate.setInterceptors(List.of(this.getBearerTokenInterceptor(accessToken)));
        }
    }

    @Override
    public Iterable<Car> getCars() {
        return List.of(
                this.restTemplate.getForObject("http://localhost:8082/api/v1/car", Car[].class)
        );
    }

    @Override
    public Car createCar(Car car) {
        return this.restTemplate.postForObject("http://localhost:8082/api/v1/car", car,Car.class);
    }

    @Override
    public void deleteCarById(long id) {
        this.restTemplate.delete(String.format("http://localhost:8082/api/v1/car/%d", id));
    }

    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
        ClientHttpRequestInterceptor interceptor = (HttpRequest request, byte[] body,
                                                    ClientHttpRequestExecution execution) -> {
            request.getHeaders().set("Authorization", "Bearer " + accessToken);
            return execution.execute(request, body);
        };
        return interceptor;
    }

}
