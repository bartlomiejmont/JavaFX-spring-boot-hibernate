package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.HousingPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingPostingRepository extends JpaRepository<HousingPosting,Long> {
}
