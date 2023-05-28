package com.spring.issuesolving.jpa.dirtychecking_performance.service;

import com.spring.issuesolving.jpa.dirtychecking_performance.entity.Board;

import java.util.List;

public interface BoardService {

    Board getBoard(Long id);

    Board getBoardWithReadOnly(Long id);

    List<Board> getBoardList();

    List<Board> getBoardListWithReadOnly();

}
