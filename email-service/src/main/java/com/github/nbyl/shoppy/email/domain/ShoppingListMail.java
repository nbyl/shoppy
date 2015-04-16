package com.github.nbyl.shoppy.email.domain;


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
