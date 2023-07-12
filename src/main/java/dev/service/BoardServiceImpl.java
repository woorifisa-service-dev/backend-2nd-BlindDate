package dev.service;

import dev.dto.BoardRequest;
import dev.entity.Board;
import dev.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public BoardRequest save(BoardRequest boardRequest) {
        return BoardRequest.from(boardRepository.save(Board.from(boardRequest)));
    }
}
