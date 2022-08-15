package com.example.shoppingcar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Commodity {
    private int id;
    private String name;
    private  String seller;
    private int price;
    private int amount;
}

