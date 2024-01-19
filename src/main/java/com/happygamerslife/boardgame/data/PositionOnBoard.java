package com.happygamerslife.boardgame.data;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PositionOnBoard {

    @NotBlank
    @Size(min = 1, max = 1)
    @Pattern(regexp = "\\{A|B|C|D|E|F|G|H|I|J}")
    private String column;
    @Size(min = 1, max = 1)
    @Pattern(regexp = "[12345678]")
    private String row;
}
