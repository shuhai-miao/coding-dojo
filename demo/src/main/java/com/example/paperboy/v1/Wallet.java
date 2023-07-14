package com.example.paperboy.v1;

import javax.money.MonetaryAmount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wallet {
    private MonetaryAmount money;

    public static Wallet of(MonetaryAmount money) {
        return new Wallet(money);
    }
}
