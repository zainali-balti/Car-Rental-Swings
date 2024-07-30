package org.example.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Vehicle {
    private Integer id;
    private String name;
    private Integer model;
    private String brand;
    private String color;
    private Integer oid;
}
