package dev.luanfernandes.domain.dto;

import dev.luanfernandes.domain.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

    public CustomerDTO(CustomerEntity customerEntity) {
        this.id = customerEntity.getId();
        this.name = customerEntity.getName();
        this.phone = customerEntity.getPhone();
        this.email = customerEntity.getEmail();
        this.address = customerEntity.getAddress();
        this.age = customerEntity.getAge();
    }

    public CustomerEntity toEntity() {
        return CustomerEntity.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .address(address)
                .age(age)
                .build();
    }
}
