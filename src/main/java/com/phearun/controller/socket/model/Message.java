package com.phearun.controller.socket.model;

public class Message {
	private String text;
	private String username;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Message [text=" + text + ", username=" + username + "]";
	}
	
}

