package dev.service;

import dev.dto.BoardReponse;
import dev.dto.BoardRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    BoardRequest save(Long userId, BoardRequest boardRequest);

    List<BoardReponse> findAll();
}
