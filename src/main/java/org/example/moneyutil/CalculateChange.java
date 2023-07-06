package org.example;

import org.example.data.RetrieveData;
import org.example.model.Coin;
import org.example.model.ChangeDTO;

import java.util.ArrayList;
import java.util.List;

public class CalculateChange {

    private RetrieveData data = RetrieveData.getInstance();

    public List<ChangeDTO> calculate(int value) {
        System.out.println(data.getAll());

        List<Coin> coinsList = data.getAll();
        List<ChangeDTO> returnCoinsList = new ArrayList<>();

        for (Coin coin : coinsList){
            if((value / coin.getValue()) >= 1) {
                int availableAmountCoins = Math.min((value / coin.getValue()), coin.getCount());

                value = value - availableAmountCoins * coin.getValue();
                data.updateCount();
                System.out.println(value);
            }
        }

        System.out.println(data.getAll());
        return returnCoinsList;
    }
}
