package org.example.retrieveData;

import org.example.domain.Coin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RetrieveData {

    private final List<Coin> coins = new ArrayList<>();

    public List<Coin> getAll() {
        return new ArrayList<>(coins.values());
    }
}
