package com.spring.issuesolving.jpa;


import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.repository.BandRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
