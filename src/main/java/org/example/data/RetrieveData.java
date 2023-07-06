package org.example.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Coin;
import org.example.model.CoinDTO;
import org.example.model.CoinMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

    private List<Coin> coins = new ArrayList<>();
    private final CoinMapper coinMapper = new CoinMapper();

    private static final RetrieveData instance = new RetrieveData();

    public static RetrieveData getInstance() {
        return instance;
    }

    private RetrieveData() {
        init();
    }

    public List<Coin> getAll() {
        return coins;
    }

    public void updateCount(long id, int newCount) {
         coins.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .ifPresent(e -> e.setCount(newCount));
    }

    private void saveAll(List<Coin> coins) {
        this.coins = coins;
    }

    public Coin getByValue(int value) {
        return coins.stream()
                .filter(e -> e.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find coin with value: " + value));
    }

    private void init(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<CoinDTO> coinsList;
        try {
            String filePath = RetrieveData.class.getResource("/data.json").getPath();
            coinsList = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Unable to load the file", e);
        }

        saveAll(coinsList.stream()
                .map(coinMapper)
                .toList());
    }
}
