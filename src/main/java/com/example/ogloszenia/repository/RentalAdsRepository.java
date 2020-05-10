package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.RentalAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalAdsRepository extends JpaRepository<RentalAds, Long> {
}
