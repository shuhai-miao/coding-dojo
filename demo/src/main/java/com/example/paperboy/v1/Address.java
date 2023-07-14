package com.example.paperboy.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    
    private static final String NOT_SPECIFIED = "NOT_SPECIFIED";
    private String street;
    private String houseNumber;

    public static Address of() {
        return new Address(NOT_SPECIFIED, NOT_SPECIFIED);
    }
}
