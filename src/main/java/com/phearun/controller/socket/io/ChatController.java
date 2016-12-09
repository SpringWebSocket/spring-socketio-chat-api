package com.phearun.controller.socket.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.phearun.controller.socket.model.Message;

@Component
public class ChatController {

	private SocketIOServer server;
	
	@Autowired
	public ChatController(SocketIOServer server){
		this.server = server;
	}
	
	@OnConnect
	public void onConnect(SocketIOClient client) {
		System.out.println("Client Connected: " + client.getSessionId());
		this.server.getBroadcastOperations().sendEvent("come", client.getSessionId());
	}
	
	@OnEvent("chat")
	public void onEvent(SocketIOClient client, Message message, AckRequest ack){
		System.out.println("->Message: " + message);
		this.server.getBroadcastOperations().sendEvent("message", message);
	}
	
	@OnDisconnect
	public void onDisconnect(SocketIOClient client) {
		System.out.println("Client Disconnected: " + client.getSessionId());
		this.server.getBroadcastOperations().sendEvent("leave", client.getSessionId());
	}
	
	@OnEvent("byte")
	public void onEvent(SocketIOClient client, byte[] data, AckRequest ack){
		System.out.println("->Message: " + data);
		//this.server.getBroadcastOperations().sendEvent("message", data);
	}
}
