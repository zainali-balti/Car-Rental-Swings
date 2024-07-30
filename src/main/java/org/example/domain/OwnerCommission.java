package org.example.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OwnerCommission {
    private Integer id;
    private String name;
    private Integer commission;
    private Integer bid;
}
