package dev.dto;

import dev.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequest {

    private String title;
    private String content;

    public static BoardRequest from(Board board){
        String title = board.getTitle();
        String content = board.getContent();

        return new BoardRequest(title, content);


    }


}
