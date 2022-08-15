package com.example.shoppingcar.Controller;


import com.example.shoppingcar.Service.ShoppingCartService;
import com.example.shoppingcar.Model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping
    public List<ShoppingCart> getShoppingCart() {

        return shoppingCartService.getShoppingCart();
    }

    @GetMapping("/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable int id) {
        return shoppingCartService.getShoppingCartById(id);
    }

    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    @PutMapping("/{id}")
    public ShoppingCart updateShoppingCart(@PathVariable int id, @RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.updateShoppingCart(id, shoppingCart);
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingCart(@PathVariable int id) {
     /*   if (null == shoppingCarService.deleteShoppingCar(id)) {
            return id + " is delete";
        }
        return null*/;
        return shoppingCartService.deleteShoppingCart(id);
    }

}
