package com.example.ogloszenia.model;

import com.example.ogloszenia.type.UserType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
//@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long id;

    @NonNull
    private String login;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    private UserType type;

}