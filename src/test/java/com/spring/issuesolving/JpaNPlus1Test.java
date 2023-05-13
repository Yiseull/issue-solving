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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class JpaNPlus1Test {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    @DisplayName("CASE 1. FetchType.EAGER")
    @Test
    void occurJpaNPlus1_EAGER() {
        // given
        Artist newJeans = new Artist("뉴진스");
        Artist maroon5 = new Artist("Maroon 5");

        Song song1 = Song.builder().title("Hype boy").artist(newJeans).build();
        Song song2 = Song.builder().title("Attention").artist(newJeans).build();
        Song song3 = Song.builder().title("OMG").artist(newJeans).build();
        Song song4 = Song.builder().title("Memories").artist(maroon5).build();

        artistRepository.saveAll(Arrays.asList(newJeans, maroon5));
        songRepository.saveAll(Arrays.asList(song1, song2, song3, song4));

        // when - JPA N+1 문제 발생: 조회는 1번 했지만 조회 쿼리는 3번 실행
        List<Artist> artists = artistRepository.findAll();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }
}
