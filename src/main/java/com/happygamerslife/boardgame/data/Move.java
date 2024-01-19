package com.happygamerslife.boardgame.data;

import com.happygamerslife.boardgame.rest.dto.Player;
import jakarta.validation.constraints.Size;
import jdk.jfr.Timestamp;

public class Move {

    @Size(min = 2, max = 2, message = "Move size validation wrong")
    PositionOnBoard from;
    @Size(min = 2, max = 2, message = "Move size validation wrong")
    PositionOnBoard to;

    @Timestamp
    long triggerTimestamp;
    Player player;
}
