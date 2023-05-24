package com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "band")
    private List<BandMember> bandMembers;

    @OneToMany(mappedBy = "band")
    private List<BandSong> bandSongs;

}
