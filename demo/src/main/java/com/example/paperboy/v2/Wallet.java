package com.example.paperboy.v2;

import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.javamoney.moneta.Money;

@Data
@AllArgsConstructor
public class Wallet {
    private MonetaryAmount money;

    public static Wallet of(MonetaryAmount money) {
        return new Wallet(money);
    }

    public MonetaryAmount takeMoney(NumberValue amount) {
        final Money extractedMoney = Money.of(amount, money.getCurrency());
        if (money.isGreaterThanOrEqualTo(extractedMoney)) {
            this.money = money.subtract(extractedMoney);
            return extractedMoney;
        } else
            return Money.of(0, money.getCurrency());
    }

    public boolean containsAmount(MonetaryAmount customerMoney) {
        return money.isGreaterThanOrEqualTo(customerMoney);
    }

    public void add(MonetaryAmount toAdd) {
        if (toAdd.isPositive())
            this.money = this.money.add(toAdd);
    }

    public MonetaryAmount getAmountOfMoney() {
        return Money.from(money);
    }
}
