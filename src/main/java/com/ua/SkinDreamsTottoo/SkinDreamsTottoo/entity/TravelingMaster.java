package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "traveling_masters")
public class TravelingMaster {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "social_media")
    private String socialMedia;

    @Column(name = "phone")
    private String phone;

    @Email
    @Column(name = "email")
    private String email;


    @Column(name = "description")
    private String description;



    @ElementCollection
    @CollectionTable(name = "traveling_master_desired_dates",
            joinColumns = @JoinColumn(name = "traveling_master_id"))
    @Column(name = "desired_date")
    private List<LocalDate> desiredDates = new ArrayList<>();

}
