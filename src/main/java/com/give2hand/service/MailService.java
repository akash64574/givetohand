package com.give2hand.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.give2hand.dto.Mail;

public interface MailService {
	public String sendEmail(Mail mail) throws MessagingException, UnsupportedEncodingException;

}
