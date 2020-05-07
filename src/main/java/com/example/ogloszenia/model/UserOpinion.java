package com.example.ogloszenia.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserOpinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long id;

    @NonNull
    private long userId;

    @NonNull
    private long userGivingOpinionId;

    @NonNull
    private String description;

    @NonNull
    @Min(1)
    @Max(5)
    private long rating;

}