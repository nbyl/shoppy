package com.github.nbyl.shoppy.shoppinglist.domain;


import com.github.nbyl.shoppy.shoppinglist.domain.ShoppingList;
import com.github.nbyl.shoppy.shoppinglist.domain.Recipient;

public class ShoppingListMail {

    private Recipient recipient;

    private ShoppingList shoppingList;

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
