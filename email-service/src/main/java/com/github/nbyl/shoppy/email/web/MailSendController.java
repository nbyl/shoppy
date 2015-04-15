package com.github.nbyl.shoppy.email.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class MailSendController {

    @Inject
    private SpringTemplateEngine templateEngine;

    @RequestMapping(value = "shoppinglist", method = RequestMethod.POST)
    public void sendShoppingList() {

    }
}
