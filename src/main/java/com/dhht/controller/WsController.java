package com.dhht.controller;

import com.dhht.model.RequestMessage;
import com.dhht.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by fyc on 18/8/7
 */
@Controller
public class WsController {

    private RequestMessage info;
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        info = message;
        return new ResponseMessage( info.getName() );
    }
}
