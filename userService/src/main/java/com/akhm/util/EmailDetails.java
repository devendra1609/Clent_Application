package com.akhm.util;

public class EmailDetails {
	private String recipieant;
	private String messageBody;
	private String subject;
	private String attachment;
	public String getRecipieant() {
		return recipieant;
	}
	public void setRecipieant(String recipieant) {
		this.recipieant = recipieant;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
}
