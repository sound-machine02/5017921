package com.example.BookstoreAPI.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private Long id;
    private String name;
    private String email;
    private String address;
}