package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "phone")
    private String phone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;
}
