package com.example.paperboy.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Wallet wallet;
    private Paper paper;
    private Address address;

    public static Customer of(Address address, Wallet wallet) {
        return new Customer(wallet, null, address);
    }
}
