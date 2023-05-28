package com.spring.issuesolving.jpa.dirtychecking_performance.repository;

import com.spring.issuesolving.jpa.dirtychecking_performance.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
