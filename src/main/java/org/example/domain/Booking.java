package org.example.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Booking {
    private  Integer id;
    private  Integer c_id;
    private  Integer v_id;
    private LocalDate date;
    private Integer price;
    private String status;
}
