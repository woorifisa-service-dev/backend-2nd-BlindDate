package dev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long boardId;
    private String userName;
    private String title;
    private String content;

    public static PostResponseDto from(String name, BoardReponse boardReponse){
        Long boardId = boardReponse.getBoardId();
        String userName = name;
        String title = boardReponse.getTitle();
        String content = boardReponse.getContent();

        return new PostResponseDto(boardId,userName, title, content);

    }

}
