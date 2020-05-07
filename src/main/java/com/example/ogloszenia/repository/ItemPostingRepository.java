package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.ItemPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPostingRepository extends JpaRepository<ItemPosting,Long> {
}
