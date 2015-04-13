package com.github.nbyl.shoppy.shoppinglist.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue
    private Integer id;

    @ElementCollection
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
