package com.github.nbyl.shoppy.email.domain;

public class ShoppingListItem {

    private String name;

    private Boolean done;

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
