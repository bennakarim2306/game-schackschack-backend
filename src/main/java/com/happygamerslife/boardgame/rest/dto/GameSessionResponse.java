package com.happygamerslife.boardgame.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSessionResponse {

    String gameId;
    GameStatus gameStatus;
    Player fistPlayer;
    Player secondPlayer;

}
