package com.spring.issuesolving.jpa.dirtychecking_performance.service;

import com.spring.issuesolving.jpa.dirtychecking_performance.entity.Board;
import com.spring.issuesolving.jpa.dirtychecking_performance.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board getBoard(Long id) {
        return boardRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public Board getBoardWithReadOnly(Long id) {
        return boardRepository.findById(id).get();
    }

    @Transactional
    @Override
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Board> getBoardListWithReadOnly() {
        return boardRepository.findAll();
    }
}
