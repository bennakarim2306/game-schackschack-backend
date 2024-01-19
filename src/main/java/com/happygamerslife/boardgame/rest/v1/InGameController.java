package com.happygamerslife.boardgame.rest.v1;


import com.happygamerslife.boardgame.data.GameSession;
import com.happygamerslife.boardgame.data.Move;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class InGameController {

    @MessageMapping("/gameSessionBroker")
    @SendTo("topic/gameMessages")
    public GameSession inGameMessage(@Payload Move nextMove)

}
