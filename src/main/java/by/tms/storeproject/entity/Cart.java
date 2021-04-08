package by.tms.storeproject.entity;

import by.tms.storeproject.storage.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    @Autowired
    private CartRepository cartRepository;

    private void addItemToCart(Item item){
        cartRepository.save(item);
    }

    public List<Item> getAllCartItems(){
        return cartRepository.findAll();
    }
}
