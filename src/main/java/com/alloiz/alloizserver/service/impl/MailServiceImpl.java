package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.service.MailService;
import com.alloiz.alloizserver.service.utils.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    private String send(String mail, String title, String template, Map<String, Object> model) {
        String text = mailContentBuilder.getFreeMarkerTemplateContent(template, model);
        mailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setTo(mail);
            messageHelper.setSubject(title);
            messageHelper.setText(text, true);
        });
        return text;
    }


    @Override
    public Callback sendCallback(Callback callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", callback.getEmail());
        map.put("phone", callback.getPhone());
        map.put("company", callback.getCompany());
        map.put("datetime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy о hh:mm:ss")));
        send("nazar.sekh@gmail.com", "Підтримка сайту Еленозе", "supportAdmin.html", map);
        send(callback.getEmail(), "Підтримка сайту Еленозе", "supportUser.html", map);
        return callback;
    }
}
