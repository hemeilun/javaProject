package com.meilun.controller;

import com.meilun.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class SentMainController {

    @Autowired
    private MailService mailService;


    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param text
     */
    @RequestMapping("/sendTextMail")
    public void sendTextMail(String to,String subject,String text){
        mailService.sendTextMailMessage(to,subject,text);
    }

    @RequestMapping("/sendHtmlMail")
    public void sendHtmlMailMessage(String to,String subject,String text){
        mailService.sendHtmlMail(to,subject,text);
    }

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     */
//    @RequestMapping("/sendAttachmentMailMessage")
//    public void sendAttachmentMailMessage(String to,String subject,String content,String filePath){
//        //本地附件路径
//        filePath="D:\\1.png";
//        mailService.sendAttachmentMailMessage(to,subject,content,filePath);
//    }

}
