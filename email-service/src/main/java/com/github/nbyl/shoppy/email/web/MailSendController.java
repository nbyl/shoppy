package com.github.nbyl.shoppy.email.web;

import com.github.nbyl.shoppy.email.domain.ShoppingListMail;
import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
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
    private ServletContext servletContext;

    @Inject
    private ApplicationContext applicationContext;

    @Inject
    private SpringTemplateEngine templateEngine;

    @Inject
    private JavaMailSender mailSender;

    @Value("${email.from:'test@example.com}")
    private String from;

    @RequestMapping(value = "shoppinglist", method = RequestMethod.POST)
    public void sendShoppingList(@RequestBody ShoppingListMail mail, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Sending shopping list {} to {}", mail.getShoppingList().getId(), mail.getRecipient().getEmail());

        String content = generateShoppingListMailContent(request, response, mail);
        LOGGER.info("Generated mail: {}", content);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, CharEncoding.UTF_8);
            message.setTo(mail.getRecipient().getEmail());
            message.setFrom(from);
            message.setSubject("Your shoppy list");
            message.setText(content, true);
            mailSender.send(mimeMessage);
            LOGGER.debug("Sent e-mail to User '{}'!", mail.getRecipient().getEmail());
        } catch (Exception e) {
            LOGGER.warn("E-mail could not be sent to user '{}', exception is: {}", mail.getRecipient().getEmail(), e.getMessage());
        }
    }

    private String generateShoppingListMailContent(HttpServletRequest request,
                                          HttpServletResponse response,
                                          ShoppingListMail mail) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("mail", mail);
        IWebContext context = new SpringWebContext(request, response, servletContext,
                Locale.ENGLISH, variables, applicationContext);
        return templateEngine.process("shoppingListMail", context);
    }
}
