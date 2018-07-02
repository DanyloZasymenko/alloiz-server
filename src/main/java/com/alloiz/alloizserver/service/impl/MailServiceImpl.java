package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.service.MailService;
import com.alloiz.alloizserver.service.utils.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

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
    public void support(String supportText, String from) {
        Map<String, Object> map = new HashMap<>();
        map.put("supportText", supportText);
        send("support@alloche.com", "Підтримка сайту Аллойз", "supportAdmin.html", map);
        send(from, "Підтримка сайту Аллойз", "supportUser.html", new HashMap<>());
    }
}
