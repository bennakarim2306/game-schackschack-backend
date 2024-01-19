package com.happygamerslife.boardgame.rest.v1;


import com.happygamerslife.boardgame.data.GameSession;
import com.happygamerslife.boardgame.rest.dto.GameSessionRequest;
import com.happygamerslife.boardgame.rest.dto.GameSessionResponse;
import com.happygamerslife.boardgame.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/gameSession")
public class GameSessionController {

    final GameService gameService;

    public GameSessionController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/initGame")
    @ResponseStatus(HttpStatus.OK)
    public GameSession startSession (@RequestBody GameSessionRequest gameSessions) {
        try{
            return gameService.initGameSession(gameSessions.getGameId(), gameSessions);
        }
        catch(Exception e) {
            log.error("some error occurred {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/gameDetails/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public GameSession getSession (@PathVariable String gameId) {
        try{
            return gameService.getGameSessionDetails(gameId);
        }
        catch(Exception e) {
            log.error("some error occurred {}", e.getMessage());
            throw e;
        }
    }

    
}
