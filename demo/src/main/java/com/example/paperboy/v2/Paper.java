package com.example.paperboy.v2;

import java.time.LocalDate;

import javax.money.MonetaryAmount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paper {
    private LocalDate date;
    private MonetaryAmount unitPriceOfPaper;

    public static Paper of(MonetaryAmount unitPriceOfPaper) {
        return new Paper(LocalDate.now(), unitPriceOfPaper);
    }

}
