package com.courses.websocket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author Stepan
 */
@ServerEndpoint(value = "/websock")
public class WebSocket {

    @OnOpen
    public void onOpen(Session session){
        System.out.println("----------- on open ------------");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("----------- on message ------------");
        System.out.println("Message : " + message);
        message += " server" ;
        session.getBasicRemote().sendText(message);
    }
}
