package com.zdj.jiapu.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

public class SendMailTask implements Runnable {
	
	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public MimeMessage getMessage() {
		return message;
	}

	public void setMessage(MimeMessage message) {
		this.message = message;
	}

	private JavaMailSender sender;
	private MimeMessage message;

	@Override
	public void run() {
		
		sender.send(message);		

	}

}
