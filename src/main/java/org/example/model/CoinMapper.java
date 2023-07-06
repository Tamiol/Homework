package org.example.model;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class CoinMapper implements Function<CoinDTO, Coin> {

    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(1L);

    @Override
    public Coin apply(CoinDTO coinDTO) {
        return new Coin(
                ID_NEXT_VALUE.getAndIncrement(),
                coinDTO.name(),
                coinDTO.value(),
                coinDTO.count()
        );
    }
}
