package com.example.tkmappterTest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

public class StompConnectEventListener implements ApplicationListener<SessionConnectEvent>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StompConnectEventListener.class);
//    @Autowired
//    SocketSessionRegistry webAgentSessionRegistry;
//    
//	
//    @Autowired
//    WebSocketService webSocketService;

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>socket连接成功！.event.getMessage:"+event.getMessage());
        //login get from browser
//        Long macId = Long.valueOf(sha.getNativeHeader("macId").get(0).trim());
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>.sessionId:{}", sha.getSessionId());
//        String sessionId = sha.getSessionId();
//        webAgentSessionRegistry.register(sessionId, macId);
    }
}
