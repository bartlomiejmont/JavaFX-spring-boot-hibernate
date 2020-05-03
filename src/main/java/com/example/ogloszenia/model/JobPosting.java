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
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long id;

    @NonNull
    private long userId;

    @NonNull
    private String jobTitle;

    @NonNull
    private String description;

    @NonNull
    private long minSalary;

    @NonNull
    private long maxSalary;

}
