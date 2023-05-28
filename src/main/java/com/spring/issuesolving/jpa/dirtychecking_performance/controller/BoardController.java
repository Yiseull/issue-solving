package com.spring.issuesolving.jpa.dirtychecking_performance.controller;

import com.spring.issuesolving.jpa.dirtychecking_performance.entity.Board;
import com.spring.issuesolving.jpa.dirtychecking_performance.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    @GetMapping("/{id}/read-only")
    public ResponseEntity<Board> getBoardWithReadOnly(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardWithReadOnly(id));
    }

    @GetMapping
    public ResponseEntity<List<Board>> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }

    @GetMapping("/read-only")
    public ResponseEntity<List<Board>> getBoardListWithReadOnly() {
        return ResponseEntity.ok(boardService.getBoardListWithReadOnly());
    }

}
