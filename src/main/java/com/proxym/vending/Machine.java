package com.proxym.vending;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    List<DinarCoin> insertedCoins = new ArrayList<>();
    int credit;

    public void insertCoin(DinarCoin coin) {
        insertedCoins.add(coin);
    }

    public List<DinarCoin> returnedCoins() {
        return insertedCoins;
    }

    public int credit() {
        return 0;
    }
}
