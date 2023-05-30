package xkq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.entity.Mail;
import xkq.service.EmailService;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private EmailService mailService;
    @Async
    @GetMapping("/post")
    public String postMail() {
        Mail mail = new Mail();
        mail.setTo("qunxianke@163.com");
        mail.setSubject("automatic");
        mail.setContent("自动邮件发布");
        mailService.sendMail(mail);
        return "发送成功";
    }

   }
