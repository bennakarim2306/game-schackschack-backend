package com.happygamerslife.boardgame.rest.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@AllArgsConstructor
public class GameSessionRequest {

    @NonNull
    @JsonProperty("playerOne")
    Player playerOne;
    @NonNull
    @JsonProperty("playerTwo")
    Player playerTwo;

    @NonNull
    @JsonProperty("gameId")
    String gameId;

    @JsonCreator
    public GameSessionRequest() {}
}
