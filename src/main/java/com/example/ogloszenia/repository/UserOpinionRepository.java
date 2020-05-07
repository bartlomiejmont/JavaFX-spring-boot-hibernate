package com.example.ogloszenia.repository;

import com.example.ogloszenia.model.UserOpinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOpinionRepository extends JpaRepository<UserOpinion,Long> {
}
