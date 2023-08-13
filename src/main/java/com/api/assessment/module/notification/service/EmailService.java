package com.api.assessment.module.notification.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender mailSender;

  public void send(String from, String to, String subject, String text) {
    log.info("send notification -> to {}", to);
    new Thread(new Runnable() {
      public void run() {
        try {
          SimpleMailMessage message = new SimpleMailMessage();
          message.setFrom(from);
          message.setTo(to);
          message.setSubject(subject);
          message.setText(text);
          mailSender.send(message);
        } catch (Exception e) {
          log.error("send notification error {}", e.getMessage());
        }
      }
    }).start();

  }

  public void sendWithAttach(String from, String to, String subject, String text, String attachName,
      InputStreamSource inputStream) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    helper.setFrom(from);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(text, true);
    helper.addAttachment(attachName, inputStream);
    mailSender.send(message);
  }

}