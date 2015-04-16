package com.github.nbyl.shoppy.email.domain;

import java.util.List;

public class ShoppingList {

    private Integer id;

    private List<ShoppingListItem> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ShoppingListItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingListItem> items) {
        this.items = items;
    }
}
