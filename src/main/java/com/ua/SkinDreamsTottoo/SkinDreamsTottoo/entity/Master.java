package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "masters")
public class Master {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "social_media")
    private String socialMedia;

    @Column(name = "image_url") // Добавленное поле для URL изображения
    private String imageURL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "master")
    List<Review> reviewList = new ArrayList<>();
}
