package com.example.ogloszenia.model;

import com.example.ogloszenia.type.HousingType;
import lombok.AllArgsConstructor;
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
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class HousingAds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private Long userId;

    @NonNull
    private String title;

    @NonNull
    private String description;

    private long price;

    private long area;

    @NonNull
    @Enumerated(EnumType.STRING)
    private HousingType type;


}