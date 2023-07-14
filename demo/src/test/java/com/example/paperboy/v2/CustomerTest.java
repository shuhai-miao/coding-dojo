package com.example.paperboy.v2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;
    private PaperBoy paperBoy;

    @BeforeEach
    public void setUp() {
        customer = Customer.of(Address.of(), new Wallet(Money.of(10, "USD")));
        paperBoy = PaperBoy.of(new Wallet(Money.of(1, "USD")));
    }

    @Test
    public void testBuyPaper() {
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));
        customer.buyPaper(paperBoy);
        Assertions.assertNotNull(customer.getPaper());
        MonetaryAmount expectedCustomerWallet = Money.of(9, "USD");
        Assertions.assertEquals(expectedCustomerWallet, customer.getWallet().getMoney());
        Assertions.assertEquals(0, paperBoy.getPapers().size());
    }

    @Test
    public void testBuyPaperWhenCustomerHasNoMoney() {
        customer.getWallet().takeMoney(Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(10).create().getNumber());
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));
        customer.buyPaper(paperBoy);
        Assertions.assertNull(customer.getPaper());
        MonetaryAmount expectedCustomerWallet = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(0).create();
        Assertions.assertEquals(expectedCustomerWallet, customer.getWallet().getMoney());
        Assertions.assertEquals(1, paperBoy.getPapers().size());
    }

    @Test
    public void testBuyPaperWhenCustomerAlreadyHasPaper() {
        customer.setPaper(Paper.of(Money.of(1, "USD")));
        paperBoy.getPapers().add(Paper.of(Money.of(1, "USD")));
        customer.buyPaper(paperBoy);
        Assertions.assertNotNull(customer.getPaper());
        MonetaryAmount expectedCustomerWallet = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(10).create();
        Assertions.assertEquals(expectedCustomerWallet, customer.getWallet().getMoney());
        Assertions.assertEquals(1, paperBoy.getPapers().size());
    }

    @Test
    public void testBuyPaperWhenPaperBoyIsOutOfPapers() {
        paperBoy.getPapers().clear();
        assertThrows(RuntimeException.class, () -> customer.buyPaper(paperBoy));
        Assertions.assertNull(customer.getPaper());
        MonetaryAmount expectedCustomerWallet = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(10).create();
        Assertions.assertEquals(expectedCustomerWallet, customer.getWallet().getMoney());
        Assertions.assertEquals(0, paperBoy.getPapers().size());
    }
}
