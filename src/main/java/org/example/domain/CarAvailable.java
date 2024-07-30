package org.example.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarAvailable {
    private Integer id;
    private String name;
    private String model;
    private String brand;
    private String color;
}
