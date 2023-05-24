package com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity;

import jakarta.persistence.*;

@Entity
public class BandSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Band band;

}
