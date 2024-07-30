package org.example.domain;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Vehicle_Owner {
    private Integer id;
    private String name;
    private String phone_No;
    private String cnic_no;
    private String address;
    private Integer commission;
}
