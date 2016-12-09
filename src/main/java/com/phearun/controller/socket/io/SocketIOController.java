/*package com.phearun.controller.socket.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.phearun.controller.socket.model.Message;

@Component
public class SocketIOController {
	
	private SocketIOServer server;

	private SocketIONamespace notificationNamespace;
	
	@Autowired
	public SocketIOController(SocketIOServer server) {
		this.server = server;
		
		this.notificationNamespace = server.addNamespace("/notification");
		
		this.notificationNamespace.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient client) {
				System.out.println("=>Notification Namespace(onConnect): " + client.getSessionId());
			}
		});
		
		this.notificationNamespace.addEventListener("like", Object.class, new DataListener<Object>() {
			@Override
			public void onData(SocketIOClient client, Object data, AckRequest ack) throws Exception {
				System.out.println("=>Notification Namespace(onEvent:like): " + data);
				
				System.out.println("isAckRequested: " + ack.isAckRequested());
				ack.sendAckData("completed!", "finished!");
				List<String> list = new ArrayList<String>();
				list.add("first");
				list.add("second");
				ack.sendAckData(list);
			}
		});
		
		this.notificationNamespace.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient client) {
				System.out.println("=>Notification Namespace(onDisconnect): " + client.getSessionId());
			}
		});
	}
	
	
	
	@OnConnect
	public void onConnect(SocketIOClient client) {
		System.out.println("Client Connected: " + client.getSessionId());
	}
	
	@OnDisconnect
	public void onDisconnect(SocketIOClient client) {
		System.out.println("Client Disconnected: " + client.getSessionId());
	}
	
	@OnEvent("chat")
	public void onEvent(SocketIOClient client, String message, AckRequest ack){
		System.out.println("->Message: " + message);
		this.server.getBroadcastOperations().sendEvent("message", message);
	}
	
	//TODO: SocketIOClient and AckRequest is optional(only for using with annotation) 
	@OnEvent("like")
	public void onLike(SocketIOClient client, String message, AckRequest ack){
		System.out.println("->Message: " + message);
		System.out.println("test");
		this.server.getBroadcastOperations().sendEvent("message", message);
	}
	
	@OnEvent(value="json")
	public void onEvent(SocketIOClient client, Message message, AckRequest ack){
		System.out.println("->Message: " + message);
		this.server.getBroadcastOperations().sendEvent("jsonmessage", message);
	}
	
	
}
*/