package com.spring.issuesolving.JpaNPlus1;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<Song> songs;

    public Artist(String name) {
        this.name = name;
    }

}
