package com.spring.issuesolving;

import com.spring.issuesolving.JpaNPlus1.Artist;
import com.spring.issuesolving.JpaNPlus1.ArtistRepository;
import com.spring.issuesolving.JpaNPlus1.Song;
import com.spring.issuesolving.JpaNPlus1.SongRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaNPlus1Test {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    @DisplayName("JPA N+1 문제 발생")
    @Transactional
    @Test
    void occurJpaNPlus1() {
        // given
        Artist newJeans = artistRepository.save(Artist.builder().name("뉴진스").build());
        Artist maroon5 = artistRepository.save(Artist.builder().name("Maroon 5").build());

        List<Song> songs = new ArrayList<>();
        songs.add(Song.builder().name("Hype boy").artist(newJeans).build());
        songs.add(Song.builder().name("Attention").artist(newJeans).build());
        songs.add(Song.builder().name("OMG").artist(newJeans).build());
        songs.add(Song.builder().name("Memories").artist(maroon5).build());
        songRepository.saveAll(songs);

        // when - JPA N+1 문제 발생: 조회는 1번 했지만 조회 쿼리는 3번 실행
        List<Artist> artists = artistRepository.findAll();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }
}
