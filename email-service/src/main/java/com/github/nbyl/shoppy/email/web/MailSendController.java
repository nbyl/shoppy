package com.github.nbyl.shoppy.email.web;

import com.github.nbyl.shoppy.email.domain.ShoppingListMail;
import com.github.nbyl.shoppy.email.services.MailSendService;
import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.context.SpringWebContext;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class MailSendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendController.class);

    @Inject
    private MailSendService sendService;

    @RequestMapping(value = "shoppinglist", method = RequestMethod.POST)
    public ResponseEntity sendShoppingList(@RequestBody ShoppingListMail mail, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Sending shopping list {} to {}", mail.getShoppingList().getId(), mail.getRecipient().getEmail());

        if(sendService.sendShoppingList(mail, request, response)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
