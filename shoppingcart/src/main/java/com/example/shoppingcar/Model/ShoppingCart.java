package com.example.shoppingcar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShoppingCart {
    private int memberId;
    private String memberName;
    private String discountCode;
    private int totalPrice;
    private List<Commodity> commodities;

    public int getTotalPrice() {
        int total = 0;
        for (Commodity commodity : this.commodities) {
            total += commodity.getPrice() * commodity.getAmount();
        }
        return total;

    }
}
