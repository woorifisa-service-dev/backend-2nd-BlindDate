package dev.controller;

import dev.dto.BoardRequest;
import dev.service.BoardService;
import dev.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @PostMapping
    public BoardRequest addBoard(@RequestBody BoardRequest boardRequest){

        return boardService.save(boardRequest);
    }

}
