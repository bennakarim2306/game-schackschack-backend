package com.happygamerslife.boardgame.rest.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@JsonDeserialize
public class Player {

    @NonNull
    String userName;

    String userId;

    boolean isPlayerOne;
    String[] gamesHistory;

    @JsonCreator
    public Player(){};
}
