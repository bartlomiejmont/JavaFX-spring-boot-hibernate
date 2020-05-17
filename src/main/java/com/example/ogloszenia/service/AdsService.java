package com.example.ogloszenia.service;

import com.example.ogloszenia.model.HousingAds;
import com.example.ogloszenia.model.ItemAds;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.RentalAds;
import com.example.ogloszenia.repository.HousingAdsRepository;
import com.example.ogloszenia.repository.ItemAdsRepository;
import com.example.ogloszenia.repository.JobPostingRepository;
import com.example.ogloszenia.repository.RentalAdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {

    @Autowired
    HousingAdsRepository housingAdsRepository;
    @Autowired
    ItemAdsRepository itemAdsRepository;
    @Autowired
    JobPostingRepository jobPostingRepository;
    @Autowired
    RentalAdsRepository rentalAdsRepository;

    public List<HousingAds> getAllHousingAds (){
        return housingAdsRepository.findAll();
    }

    public List<ItemAds> getAllItemAds(){
        return itemAdsRepository.findAll();
    }

    public List<JobPosting> getAllJobPostings(){
        return jobPostingRepository.findAll();
    }

    public List<RentalAds> getAllRentalsAds(){
        return rentalAdsRepository.findAll();
    }

}
