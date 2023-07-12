package dev.service;

import dev.dto.BoardRequest;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    BoardRequest save(BoardRequest boardRequest);
}
