package com.example.shoppingcar.Service;

import com.example.shoppingcar.Exception.NotFoundException;
import com.example.shoppingcar.Exception.PointExistException;
import com.example.shoppingcar.Model.Commodity;
import com.example.shoppingcar.Model.ShoppingCart;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    List<Commodity> commodityList;
    List<ShoppingCart> shoppingCartList;

    public ShoppingCartService() {
        super();
        this.commodityList = new ArrayList<>();
        this.shoppingCartList = new ArrayList<>();
        /*this.commodityList.add(new Commodity(459621,"cup","大台美",100,1));
        this.commodityList.add(new Commodity(65535,"persian Cat","Pet Shop",54000,10));
         this.commodityList.add(new Commodity(765934,"Lay's potato chips","7-11",35,3));
        this.commodityList.add(new Commodity(766553,"ASUS Vivobook","三井3C",29600,2));*/
        // this.shoppingCarsList.add(new ShoppingCar("Wally","MXC1234",100000,commodityList));
        // this.shoppingCarsList.add(new ShoppingCar("Vicent"));
        this.shoppingCartList.add(ShoppingCart.builder()
                .memberId(38901)
                .memberName("Vincent")
                .discountCode("無")
                //  .totalPrice()
                .commodities(List.of(new Commodity(65535, "persian Cat", "Pet Shop", 54000, 10),
                        new Commodity(766553, "ASUS Vivobook", "三井3C", 29600, 2)))
                .build());
        this.shoppingCartList.add(ShoppingCart.builder()
                .memberId(45890)
                .memberName("Wally")
                .discountCode("Shopping1111")
                .commodities(List.of(new Commodity(459621, "cup", "大台美", 100, 1)))
                .build());
        this.shoppingCartList.add(ShoppingCart.builder()
                .memberId(7890)
                .memberName("Infinite")
                .discountCode("NewGift")
                .commodities(List.of(new Commodity(30196, "CatFood", "Costco", 3000, 5)
                        , new Commodity(309681, "Cat Litter", "amazon", 1000, 3)
                        , new Commodity(30471, "Cat nest", "Trader Joe’s", 300, 2)))
                .build());
        this.shoppingCartList.add(ShoppingCart.builder()
                .memberId(123456)
                .memberName("Peter")
                .discountCode("無")
                //  .totalPrice()
                .commodities(List.of(new Commodity(96552, "Ragdoll", "shelter", 0, 3),
                        new Commodity(94392, "British Shorthair", "Pet Smart", 50000, 2),
                        new Commodity(97643, "Ashera", "PETCO", 3700000, 10)))
                .build());
    }

    public List<ShoppingCart> getShoppingCart() {
        return this.shoppingCartList;
    }


    public ShoppingCart getShoppingCartById(int Id) {
        //    int total = 0;
        for (ShoppingCart shoppingCart : this.shoppingCartList) {
            if (Id == shoppingCart.getMemberId()) {
              /*  for (Commodity commodity : this.commodityList) {
                  //  int total = 0;
                    total = total + commodity.getPrice();
                    shoppingCarList.add(ShoppingCar.builder().totalPrice(total).build());
                }*/
                return shoppingCart;
            }
        }
        throw new NotFoundException(Id);
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        for (ShoppingCart creatShoppigCar : this.shoppingCartList) {
            int check = shoppingCart.getMemberId();
            if (creatShoppigCar.getMemberId() == check) {
                throw new PointExistException(shoppingCart.getMemberId());
            }
        }
        this.shoppingCartList.add(shoppingCart);
        return shoppingCart;

    }

    public ShoppingCart updateShoppingCart(int Id, ShoppingCart shoppingCart) {
        for (ShoppingCart updateShoppingCart : this.shoppingCartList) {
            if (Id == shoppingCart.getMemberId()) {
                updateShoppingCart.setMemberName(shoppingCart.getMemberName());
                updateShoppingCart.setTotalPrice(shoppingCart.getTotalPrice());
                updateShoppingCart.setDiscountCode(shoppingCart.getDiscountCode());
                updateShoppingCart.setCommodities(shoppingCart.getCommodities());
                return updateShoppingCart;
            }
        }
        throw new NotFoundException(Id);
    }


    public String deleteShoppingCart(int Id) {
        for (ShoppingCart shoppingCart : this.shoppingCartList) {
            if (Id == shoppingCart.getMemberId()) {
                shoppingCartList.remove(shoppingCart);
                return Id + " has delete";
            }
        }
        throw new NotFoundException(Id);
    }
}
