package com.akhm.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;


@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;
	public String sendSimpleMail(EmailDetails emailDetails)
	{
		try {
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom(sender);
			message.setTo(emailDetails.getRecipieant());
			message.setText(emailDetails.getMessageBody());
			message.setSubject(emailDetails.getSubject());
			javaMailSender.send(message);
			 return "success"; 
		} catch (Exception e) {
			return "fail";
		}
	}
	public String sendMailWithAttachment(EmailDetails emailDetails)
	{
		try {
			MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom(sender);
			messageHelper.setTo(emailDetails.getRecipieant());
			messageHelper.setText(emailDetails.getMessageBody());
			messageHelper.setSubject(emailDetails.getSubject());
			FileSystemResource file=new FileSystemResource(new File(emailDetails.getAttachment()));
			messageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessage);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}
}