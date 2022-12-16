package com.proxym.vending;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class VendingMachineTest {

    @ParameterizedTest
    @DisplayName("Valid coins")
    @ValueSource(ints = {5, 10, 20, 50, 100, 200})
    public void validCoinsTest(int value) {
        // given a coin value

        // when I try to forge a coin
        Coin coin = new Coin(value);

        // then
        assertThat(coin.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("Invalid coins")
    @ValueSource(ints = {6, 11, -5, 0})
    public void invalidCoinTest(int value) {
        assertThatExceptionOfType(BadCoinException.class)
                .isThrownBy(() -> new Coin(value));
    }

    @Test
    public void rejectedCoins() {
        // Given a dinar coin
        DinarCoin dinarCoin = new DinarCoin(10);
        Machine machine = new Machine();

        // When I insert the coin in the machine
        machine.insertCoin(dinarCoin);

        // Then the machine returns my coin
        assertThat(machine.returnedCoins()).contains(dinarCoin);
    }

    @Test
    public void insertCoin() {
        // given a valid coin
        Coin coin = new Coin(10);
        Machine machine = new Machine();

        // when i insert the coin
        machine.insertCoin(coin);

        // then my credit is increased
        assertThat(machine.credit()).isEqualTo(10);
    }

    @Test
    public void insertTwoCoin() {
        // given a valid coin
        Coin coin = new Coin(10);
        Coin dinarCoin = new DinarCoin(10);
        Machine machine = new Machine();

        // when i insert the coin
        machine.insertCoin(coin);
        machine.insertCoin(dinarCoin);

        // then my credit is increased
        assertThat(machine.credit()).isEqualTo(10);
    }

}
