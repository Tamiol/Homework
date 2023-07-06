package org.example.moneyutil;

import org.example.data.RetrieveData;
import org.example.model.Coin;
import org.example.model.ChangeDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateChange implements CalculateChangeUseCase {

    private RetrieveData data = RetrieveData.getInstance();

    @Override
    public List<ChangeDTO> calculate(int value) {

        List<Coin> coinsList = data.getAll();
        List<ChangeDTO> returnCoinsList = new ArrayList<>();

        var totalValue = coinsList.stream()
                .map(e -> e.getValue() * e.getCount())
                .reduce(Integer::sum)
                .get();

        if(totalValue < value) {
            return Collections.emptyList();
        }

        for (Coin coin : coinsList){
            if((value / coin.getValue()) >= 1) {
                int availableAmountCoins = Math.min((value / coin.getValue()), coin.getCount());
                int newCount = coin.getCount() - availableAmountCoins;

                value = value - (availableAmountCoins * coin.getValue());

                data.updateCount(coin.getId(), newCount);
                if (availableAmountCoins != 0) {
                    returnCoinsList.add(new ChangeDTO(coin.getName(), availableAmountCoins));
                }
            }
        }

        return returnCoinsList;
    }
}
