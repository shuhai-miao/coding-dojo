package com.example.paperboy.v1;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaperBoy {
    private Wallet wallet;
    private List<Paper> papers;

    public static PaperBoy of(Wallet wallet) {
        return new PaperBoy(wallet, new ArrayList<>());
    }
}
