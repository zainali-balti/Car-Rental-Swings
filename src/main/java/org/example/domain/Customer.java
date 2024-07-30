package org.example.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {
    private Long id;
    private String name;
    private String phone_Number;
    private String cnic_No;
    private String address;
}
