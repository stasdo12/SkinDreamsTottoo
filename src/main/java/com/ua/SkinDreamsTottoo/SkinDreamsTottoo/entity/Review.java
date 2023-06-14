package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "review")
public class Review {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master master;
}
