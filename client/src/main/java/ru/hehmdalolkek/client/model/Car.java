package ru.hehmdalolkek.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;

    private String brand;

    private String model;

    private String color;

}
