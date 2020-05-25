package com.example.ogloszenia.service;

import com.example.ogloszenia.model.HousingAds;
import com.example.ogloszenia.model.ItemAds;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.RentalAds;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.HousingAdsRepository;
import com.example.ogloszenia.repository.ItemAdsRepository;
import com.example.ogloszenia.repository.JobPostingRepository;
import com.example.ogloszenia.repository.RentalAdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addHousingAd(HousingAds housingAds) {
        housingAdsRepository.save(housingAds);
    }

    public void deleteHousingAd (Long id) {
        Optional.of(housingAdsRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    housingAdsRepository.deleteById(id);
                    return null;
                });
    }

    public List<ItemAds> getAllItemAds(){
        return itemAdsRepository.findAll();
    }

    public void addItemAd(ItemAds itemAds) {
        itemAdsRepository.save(itemAds);
    }

    public void deleteItemAd (Long id) {
        Optional.of(itemAdsRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    itemAdsRepository.deleteById(id);
                    return null;
                });
    }

    public List<JobPosting> getAllJobPostings(){
        return jobPostingRepository.findAll();
    }

    public void addJobPosting(JobPosting jobPosting) {
        jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting (Long id) {
        Optional.of(jobPostingRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    jobPostingRepository.deleteById(id);
                    return null;
                });
    }

    public List<RentalAds> getAllRentalsAds(){
        return rentalAdsRepository.findAll();
    }

    public void addRentalAd(RentalAds rentalAds) {
        rentalAdsRepository.save(rentalAds);
    }

    public void deleteRentalAd (Long id) {
        Optional.of(rentalAdsRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    rentalAdsRepository.deleteById(id);
                    return null;
                });
    }
}
