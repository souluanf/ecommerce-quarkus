package dev.luanfernandes.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;
}
