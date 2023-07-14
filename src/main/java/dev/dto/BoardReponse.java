package dev.dto;

import dev.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardReponse {
    private Long boardId;
    private String title;
    private String content;
    private Long userId;

    public static BoardReponse from(Board board){
        Long boardId = board.getBoardId();
        String title = board.getTitle();
        String content = board.getContent();
        Long userId = board.getUserId();
        return new BoardReponse(boardId,title, content, userId);
    }
}
