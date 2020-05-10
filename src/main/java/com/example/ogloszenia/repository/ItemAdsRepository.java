package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.ItemAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAdsRepository extends JpaRepository<ItemAds,Long> {
}
