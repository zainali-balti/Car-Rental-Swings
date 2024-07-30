package org.example.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String confirmPassword;
}
