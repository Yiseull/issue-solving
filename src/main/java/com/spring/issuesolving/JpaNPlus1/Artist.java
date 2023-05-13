package com.spring.issuesolving.JpaNPlus1;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistId;
    private String name;
    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Song> songs;
}
