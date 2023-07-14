package com.example.paperboy.v1;

import java.util.Set;

import javax.money.MonetaryAmount;

//
// TODO Single Responsibility Principle
// A class should have only one reason to change, a single responsibility. 
// The single responsibility principle aims to achieve loosely coupled and highly cohesive classes. 
// The logic concerning paperboy and customer is scattered. 
//

public class PaperBoyRoundService {

    public void deliverPapers(PaperBoy paperBoy, Set<Customer> customers) {
        customers.stream()
                .forEach(customer -> deliverPaper(paperBoy, customer));
    }

    // TODO Tell, don't ask!
    // Tell objects what you want them to do, don’t take their state and make the
    // decisions for them. It is clear that in the deliverPaper method the objects
    // are asked for their state and we make a decision for them. This breaks
    // encapsulation. This is inherent to the anemic domain model pattern. A service
    // object will always ask an object for it’s state and then act on it, rather
    // then telling an object to do something.

    // TODO Law of Demeter
    // Simply put the law of Demeter boils down to objects only requiring limited
    // knowledge about other units.
    private void deliverPaper(PaperBoy paperBoy, Customer customer) {
        final MonetaryAmount unitPriceOfPaper = getPaper(paperBoy).getUnitPriceOfPaper();
        // TODO Feature envy
        // When a method accesses most of another object’s data to do it’s job.
        if (customer.getWallet().getMoney().isGreaterThanOrEqualTo(unitPriceOfPaper)) {
            customer.setPaper(getPaper(paperBoy));
            paperBoy.getPapers().remove(0);

            // TODO Message Chains (a.k.a. Train Wrecks)
            // Long chained methods that make it hard to comprehend what happens. The fun
            // realy starts when you have a nullpointer on that line.
            customer.getWallet().setMoney(customer.getWallet().getMoney().subtract(unitPriceOfPaper));
            paperBoy.getWallet().setMoney(paperBoy.getWallet().getMoney().add(unitPriceOfPaper));
        }
    }

    private Paper getPaper(PaperBoy paperBoy) {
        if (paperBoy.getPapers().isEmpty())
            throw new RuntimeException(paperBoy + " is out of papers!");
        else
            return paperBoy.getPapers().get(0);
    }
}
