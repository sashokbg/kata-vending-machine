package com.proxym.vending;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private final List<Coin> insertedCoins = new ArrayList<>();
    private final List<Coin> returnedCoins = new ArrayList<>();

    public void insertCoin(Coin coin) {
        if(!(coin instanceof DinarCoin)) {
            insertedCoins.add(coin);
        } else {
            returnedCoins.add(coin);
        }
    }

    public List<Coin> returnedCoins() {
        return returnedCoins;
    }

    public int credit() {
        return insertedCoins.stream()
                .map(Coin::value)
                .reduce(0, Integer::sum);
    }
}
