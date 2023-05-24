package com.spring.issuesolving.jpa;


import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity.Band;
import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.repository.BandRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MultipleFetchJoinTest {

    @Autowired
    private BandRepository bandRepository;

    @DisplayName("MultipleBagFetchException 예외 발생")
    @Test
    public void MultipleBagFetchExceptionTest() {
        assertThatThrownBy(() -> bandRepository.findAllWithFetchJoin())
                .isInstanceOf(InvalidDataAccessApiUsageException.class)
                .hasMessageContaining("MultipleBagFetchException");
    }

    @Nested
    @DisplayName("솔루션")
    class Solution {

        @DisplayName("1. Set 사용")
        @Test
        public void UseSet() {
            // when
            List<Band> bandList = bandRepository.findAllWithFetchJoin();
            // then
            assertThat(bandList.size()).isEqualTo(2);
        }

        @DisplayName("2. List 사용")
        @Test
        public void UseList() {
            // when
            List<Band> bandList = bandRepository.findAllWithFetchJoin();
            // then
            assertThat(bandList.size()).isEqualTo(2);
        }
    }
}
