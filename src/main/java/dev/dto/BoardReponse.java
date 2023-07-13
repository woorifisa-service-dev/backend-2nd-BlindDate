package dev.dto;

import dev.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardReponse {
    private String title;
    private String content;
    private Long userId;

    public static BoardReponse from(Board board){

        String title = board.getTitle();
        String content = board.getTitle();
        Long userId = board.getUserId();
        return new BoardReponse(title, content, userId);
    }
}
