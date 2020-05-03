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

@Entity
@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RentalPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long id;

    @NonNull
    private long userId;

    @NonNull
    private String postingTitle;

    @NonNull
    private String description;

    @NonNull
    private long costPerDay;

}