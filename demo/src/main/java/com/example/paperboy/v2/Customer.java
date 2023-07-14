package com.example.paperboy.v2;

import java.util.Optional;

import javax.money.MonetaryAmount;

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

    public void buyPaper(PaperBoy paperBoy) {
        final MonetaryAmount price = paperBoy.getPaperPrice();
        if (wantsPaper(price)) {
            final MonetaryAmount money = wallet.takeMoney(price.getNumber());
            final Optional<Paper> optionalPaper = paperBoy.sellPaper(money);
            if (optionalPaper.isPresent())
                this.setPaper(optionalPaper.get());
            else
                wallet.add(money);
        }
    }

    private boolean wantsPaper(MonetaryAmount price) {
        return !hasPaper() && hasMoney(price);
    }

    public boolean hasPaper() {
        return paper != null;
    }

    public boolean hasMoney(MonetaryAmount customerMoney) {
        return wallet.containsAmount(customerMoney);
    }

}
