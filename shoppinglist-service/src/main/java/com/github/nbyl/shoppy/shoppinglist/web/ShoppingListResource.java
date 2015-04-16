package com.github.nbyl.shoppy.shoppinglist.web;

import com.github.nbyl.shoppy.shoppinglist.domain.ShoppingList;
import com.github.nbyl.shoppy.shoppinglist.persistence.ShoppingListRepository;
import com.github.nbyl.shoppy.shoppinglist.web.dto.Recipient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import java.util.Optional;

@RestController
public class ShoppingListResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingListResource.class);

    @Inject
    private ShoppingListRepository repository;

    @RequestMapping(value = "/shoppinglists/{id}/send", method = RequestMethod.POST)
    public ResponseEntity sendShoppingList(@PathVariable Integer id, @RequestBody Recipient recipient) {
        return Optional.ofNullable(repository.findOne(id))
                .map(shoppingList -> {
                    sendShoppingListEmail(shoppingList, recipient);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private void sendShoppingListEmail(ShoppingList shoppingList, Recipient recipient) {
        LOGGER.info("Sending shopping list {} to {}", shoppingList.getId(), recipient.getEmail());
    }
}
