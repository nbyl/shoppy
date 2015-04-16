package com.github.nbyl.shoppy.email.web;

import com.github.nbyl.shoppy.email.domain.ShoppingListMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.inject.Inject;

@RestController
public class MailSendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendController.class);

    @Inject
    private SpringTemplateEngine templateEngine;

    @RequestMapping(value = "shoppinglist", method = RequestMethod.POST)
    public void sendShoppingList(@RequestBody ShoppingListMail mail) {

        LOGGER.info("Sending shopping list {} to {}", mail.getShoppingList().getId(), mail.getRecipient().getEmail());

    }
}
