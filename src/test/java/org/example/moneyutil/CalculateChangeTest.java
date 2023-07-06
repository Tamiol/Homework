package org.example.moneyutil;

import org.example.data.RetrieveData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculateChangeTest {

    public CalculateChange calculateChange = new CalculateChange();

    @Test
    public void user_give_550_change_should_decrement_500_value_and_50_value_coins_count() {
        //given
        var change = 550;
        var data = RetrieveData.getInstance();

        //when
        calculateChange.calculate(change);

        //then

        assertEquals(data.getByValue(500).getCount(), 0);
        assertEquals(data.getByValue(50).getCount(), 9);
    }

}