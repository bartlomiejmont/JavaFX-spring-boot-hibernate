package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.HousingAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingAdsRepository extends JpaRepository<HousingAds,Long> {
}
