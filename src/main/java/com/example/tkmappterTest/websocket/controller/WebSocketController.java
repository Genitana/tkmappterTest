package com.example.tkmappterTest.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.example.tkmappterTest.websocket.message.AricMessage;
import com.example.tkmappterTest.websocket.message.AricResponse;

/**
 * webSocket控制器
 */
@Controller
public class WebSocketController {

    //通过simpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    //在springmvc中,可以直接在参数中获得principal,pinciple中包含当前用户信息
    public void handleChat(String message){
    	String msg = JSON.parseObject(message).getString("name");
        if ("tom".equals(msg)) {//硬编码,对用户姓名进行判断
            //向用户发送消息,第一个参数:接收消息的用户,第二个参数:浏览器订阅地址,第三个参数:消息
            simpMessagingTemplate.convertAndSendToUser("jerry", 
                    "/queue/notifications", msg + "-send: " + msg);
            System.out.println(">>>>>>>>>>>>>>>>>>>/chat，to jerry 点对点。。。");
        } else {
            simpMessagingTemplate.convertAndSendToUser("tom", 
                    "/queue/notifications", msg + "-send: " + msg);
            System.out.println(">>>>>>>>>>>>>>>>>>/chat，to tom 点对点。。。");
        }
    }

    @MessageMapping("/welcome") //当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
    @SendTo("/topic/getResponse")//当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
    public AricResponse say(String message) {
        try {
            //睡眠3秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("/topic/getResponse  广播。。。");
        return new AricResponse("welcome," + message + "!");
    }
}