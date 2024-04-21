package com.example.paperboy.v2;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import javax.money.MonetaryAmount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaperBoy {
    private Wallet wallet;
    private Stack<Paper> papers;

    public static PaperBoy of(Wallet wallet) {
        return new PaperBoy(wallet, new Stack<>());
    }

    public void loadPapers(List<Paper> papers) {
        this.papers.addAll(papers);
    }

    public Optional<Paper> sellPaper(MonetaryAmount money) {
        if (hasSufficientMoney(money) && stillHasPapersToSell())
            return makeTransfer(money);
        else
            return Optional.empty();
    }

    public MonetaryAmount getPaperPrice() {
        if (papers.isEmpty())
            throw new RuntimeException(this + " is out of papers!");
        else
            return papers.peek().getUnitPriceOfPaper();
    }

    public MonetaryAmount getAmountOfMoney() {
        return wallet.getMoney();
    }

    private boolean stillHasPapersToSell() {
        return !papers.isEmpty();
    }

    // delegate to wallet
    private Optional<Paper> makeTransfer(MonetaryAmount money) {
        wallet.setMoney(money.add(wallet.getMoney()));
        return Optional.of(papers.pop());
    }

    private boolean hasSufficientMoney(MonetaryAmount money) {
        final MonetaryAmount priceOfPaper = getPaperPrice();
        return !priceOfPaper.isGreaterThan(money);
    }

}
