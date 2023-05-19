package com.spring.issuesolving.jpa.nplus1.repository;

import com.spring.issuesolving.jpa.nplus1.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
