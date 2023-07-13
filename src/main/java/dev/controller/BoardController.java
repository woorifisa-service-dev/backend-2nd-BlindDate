package dev.controller;

import dev.dto.BoardReponse;
import dev.dto.BoardRequest;
import dev.dto.PostResponseDto;
import dev.dto.UserRequest;
import dev.entity.User;
import dev.service.BoardService;
import dev.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {



    private final BoardService boardService;
    private final UserService userService;

    //게시글 작성
    @PostMapping
    public BoardRequest addBoard(@RequestBody BoardRequest boardRequest, HttpSession session){
        UserRequest userRequest= (UserRequest)session.getAttribute("user");
        String email = userRequest.getEmail();

        Long userId = userService.findByEmail(email);

        return boardService.save(userId, boardRequest);

    }

    @GetMapping
    public List<PostResponseDto> getBoardList(){
        List<BoardReponse> boardReponses = boardService.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for (BoardReponse boardReponse:boardReponses) {
            Long userId = boardReponse.getUserId();
            String userName = userService.findByUserId(userId);
            PostResponseDto postResponseDto = PostResponseDto.from(userName, boardReponse);
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }

}
