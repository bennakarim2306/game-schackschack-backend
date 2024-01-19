package com.happygamerslife.boardgame.data;

import com.happygamerslife.boardgame.rest.dto.GameSessionRequest;
import com.happygamerslife.boardgame.rest.dto.GameStatus;
import com.happygamerslife.boardgame.rest.dto.Player;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class GameSession {

    String gameId;
    Player firstPlayer;
    Player secondPlayer;
    long startTimestamp = System.currentTimeMillis();
    long endTimestamp;
    Integer numberOfMoves;
    ArrayList<Move> moves;
    String winner;
    GameStatus gameStatus;

    public static GameSession createFromRequest(GameSessionRequest gameSessionRequest) {
        return new GameSessionBuilder().gameId(gameSessionRequest.getGameId())
                .firstPlayer(gameSessionRequest.getPlayerOne())
                .secondPlayer(gameSessionRequest.getPlayerTwo())
                .build();
    }
}
