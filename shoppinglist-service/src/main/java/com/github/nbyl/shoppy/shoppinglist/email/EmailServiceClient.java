package com.github.nbyl.shoppy.shoppinglist.email;

import com.github.nbyl.shoppy.shoppinglist.domain.ShoppingListMail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("email")
public interface EmailServiceClient {

    @RequestMapping(value="/shoppinglist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendShoppingListEmail(ShoppingListMail mail);
}
