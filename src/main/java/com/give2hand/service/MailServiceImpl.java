package com.give2hand.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.give2hand.constant.AppConstant;
import com.give2hand.dto.Mail;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender mailSender;

	public String sendEmail(Mail mail) throws MessagingException, UnsupportedEncodingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setSubject(mail.getMailSubject());
		mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), AppConstant.PRODUCT_NAME));
		mimeMessageHelper.setTo(mail.getMailTo());
		mimeMessageHelper.setText(mail.getMailContent());
		mailSender.send(mimeMessageHelper.getMimeMessage());
        return AppConstant.SUCCESS_MESSAGE;
	}

}
