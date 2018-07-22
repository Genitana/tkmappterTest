package com.example.tkmappterTest.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class StompDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {
//    @Autowired
//    SocketSessionRegistry webAgentSessionRegistry;

    @Override  // TODO
    public void onApplicationEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>.event.getMessage:"+event.getMessage());
        String sessionId = sha.getSessionId();
        System.out.println(">>>>>>>>>>>>>>>>>>>断开连接,sessionId:"+sessionId);
//        webAgentSessionRegistry.unregister(sessionId);
    }
}
