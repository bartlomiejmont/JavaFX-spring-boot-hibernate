package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.RentalPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPostingRepository extends JpaRepository<RentalPosting, Long> {
}
