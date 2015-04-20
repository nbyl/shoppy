package com.github.nbyl.shoppy.email.services;

import com.github.nbyl.shoppy.email.domain.ShoppingListMail;
import com.github.nbyl.shoppy.email.web.MailSendController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.context.SpringWebContext;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class MailSendService {

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

    @HystrixCommand(fallbackMethod = "sendShoppingListFallback")
    public boolean sendShoppingList(@RequestBody ShoppingListMail mail, HttpServletRequest request, HttpServletResponse response) {
        String content = generateShoppingListMailContent(request, response, mail);
        LOGGER.info("Generated mail: {}", content);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, CharEncoding.UTF_8);
            message.setTo(mail.getRecipient().getEmail());
            message.setFrom(from);
            message.setSubject("Your shoppy list");
            message.setText(content, true);
            mailSender.send(mimeMessage);

            LOGGER.debug("Sent e-mail to User '{}'!", mail.getRecipient().getEmail());

            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean sendShoppingListFallback(@RequestBody ShoppingListMail mail, HttpServletRequest request, HttpServletResponse response) {
        return false;
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
