package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coin {
    private long id;
    private String name;
    private int value;
    private int count;
}
