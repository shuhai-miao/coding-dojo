package com.example.paperboy.v2;

import java.util.Set;

public class PaperBoyRoundService {

    public void deliverPapers(PaperBoy paperBoy, Set<Customer> customers) {
        customers.stream()
                .forEach(customer -> deliverPaper(paperBoy, customer));
    }
 
    private void deliverPaper(PaperBoy paperBoy, Customer customer) {
        customer.buyPaper(paperBoy);
    }

}
