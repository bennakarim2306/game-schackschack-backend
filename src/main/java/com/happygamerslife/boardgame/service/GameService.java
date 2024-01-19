package com.happygamerslife.boardgame.service;


import com.happygamerslife.boardgame.data.GameSession;
import com.happygamerslife.boardgame.data.Move;
import com.happygamerslife.boardgame.rest.dto.GameSessionRequest;
import com.happygamerslife.boardgame.rest.dto.GameSessionResponse;
import com.happygamerslife.boardgame.rest.dto.GameStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class GameService {

    private final CacheManager cacheManager;

    public GameService(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    @Cacheable(cacheNames = "gameCache", key = "#gameId")
    public GameSession initGameSession(String gameId, GameSessionRequest gameSessionRequest) {
        GameSession gameSession = new GameSession();
        gameSession.setGameStatus(GameStatus.INITIATED);
        gameSession.setGameId(gameSessionRequest.getGameId());


        log.info("A new game session was initialized with gameId: {} and status {}", gameSession.getGameId(), gameSession.getGameStatus());
        return gameSession;
    }

    public GameSession getGameSessionDetails(String gameId) {
        GameSession gameSession = (GameSession) Objects.requireNonNull(Objects.requireNonNull(this.cacheManager.getCache("gameCache")).get(gameId)).get();
        assert gameSession != null;
        log.info("Found entry with key: {} and value {}", gameId, gameSession.toString());
        return gameSession;
    }

    @CachePut(cacheNames = "gameCache", key = "#gameId")
    public GameSession updateSessionWithOneMove(String gameId, Move move){
        GameSession gameSession = (GameSession) Objects.requireNonNull(Objects.requireNonNull(this.cacheManager.getCache("gameCache")).get(gameId)).get();
        assert gameSession != null;
        gameSession.getMoves().add(move);
        return gameSession;
    }
}
