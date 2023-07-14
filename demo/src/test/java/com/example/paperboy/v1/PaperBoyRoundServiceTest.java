package com.example.paperboy.v1;

import java.util.HashSet;
import java.util.Set;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaperBoyRoundServiceTest {

    private PaperBoyRoundService paperBoyRoundService;
    private PaperBoy paperBoy;
    private Set<Customer> customers;

    @BeforeEach
    public void setUp() {
        paperBoyRoundService = new PaperBoyRoundService();
        paperBoy = PaperBoy.of(new Wallet(Money.of(10, "USD")));
        customers = new HashSet<>();
        customers.add(Customer.of(Address.of(), new Wallet(Money.of(20, "USD"))));
        customers.add(Customer.of(Address.of(), new Wallet(Money.of(5, "USD"))));
    }

    @Test
    public void testDeliverPapers() {
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));

        paperBoyRoundService.deliverPapers(paperBoy, customers);

        Assertions.assertEquals(1, paperBoy.getPapers().size());
        Assertions.assertEquals(2, customers.stream().filter(customer -> customer.getPaper() != null).count());
        MonetaryAmount expectedPaperBoyWallet = Money.of(12, "USD");
        Assertions.assertEquals(expectedPaperBoyWallet, paperBoy.getWallet().getMoney());
        MonetaryAmount expectedCustomerWallet1 = Money.of(19, "USD");
        Assertions.assertEquals(expectedCustomerWallet1, customers.stream().filter(customer -> customer.getWallet().getMoney().getNumber().intValue() == 19).findFirst().get().getWallet().getMoney());
        MonetaryAmount expectedCustomerWallet2 = Money.of(4, "USD");
        Assertions.assertEquals(expectedCustomerWallet2, customers.stream().filter(customer -> customer.getWallet().getMoney().getNumber().intValue() == 4).findFirst().get().getWallet().getMoney());
    }

    @Test
    public void testDeliverPapersWhenPaperBoyIsOutOfPapers() {
        Assertions.assertThrows(RuntimeException.class, () -> paperBoyRoundService.deliverPapers(paperBoy, customers));
    }
}