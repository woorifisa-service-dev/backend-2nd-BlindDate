package dev.service;

import dev.dto.BoardReponse;
import dev.dto.BoardRequest;
import dev.entity.Board;
import dev.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public BoardRequest save(Long userId, BoardRequest boardRequest) {
        return BoardRequest.from(boardRepository.save(Board.from(userId,boardRequest)));
    }

    @Override
    public List<BoardReponse> findAll() {
        List<Board> boards= boardRepository.findAll();

        List<BoardReponse> boardReponses = boards.stream()
                .map(BoardReponse::from)
                .collect(Collectors.toList());
//        List<BoardRequest> boardRequests = new ArrayList<>();
//        for (Board board:boards) {
//            boardRequests.add(BoardRequest.from(board));
//        }
        return boardReponses;
    }


}
