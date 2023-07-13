//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.entity;

import dev.dto.BoardRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @JoinColumn(name = "userID")
    private Long userId;

    private String title;
    private String content;

    public Board(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }


    public static Board from(Long id, BoardRequest boardRequest) {
        Long userId = id;
        String title = boardRequest.getTitle();
        String content = boardRequest.getContent();

        return new Board(userId, title, content);
    }
}
