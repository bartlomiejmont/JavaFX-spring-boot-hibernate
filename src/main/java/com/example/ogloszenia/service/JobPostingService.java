package com.example.ogloszenia.service;

import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.QJobPosting;
import com.example.ogloszenia.model.QUser;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.JobPostingRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    JobPostingRepository jobPostingRepository;

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public void addJobPosting(JobPosting jobPosting) {
        jobPostingRepository.save(jobPosting);
    }

    public void editJobPosting(JobPosting jobPosting, Long id) {
        jobPosting.setId(id);
        jobPostingRepository.findById(id)
                .map(__ -> jobPostingRepository.save(jobPosting));
    }

    public void deleteJobPosting(Long id) {
        Optional.of(jobPostingRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    jobPostingRepository.deleteById(id);
                    return null;
                });

    }

    public Optional<JobPosting> getJobPostingByTitle(String title) {
        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        QJobPosting qJobPosting = QJobPosting.jobPosting;
        JobPosting jobPosting = query.select(qJobPosting)
                .from(qJobPosting)
                .where(qJobPosting.jobTitle.eq(title))
                .fetchOne();
        return Optional.ofNullable(jobPosting);
    }
}
