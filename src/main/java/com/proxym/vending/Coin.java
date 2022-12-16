package com.proxym.vending;

import java.util.List;

public class Coin {

    List<Integer> VALID_COIN_VALUES = List.of(5, 10, 20, 50, 100, 200);
    private int value;
    public Coin(int value) {
        if(!VALID_COIN_VALUES.contains(value)){
            throw new BadCoinException();
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
