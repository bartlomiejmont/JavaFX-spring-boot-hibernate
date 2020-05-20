package com.example.ogloszenia.service;

import com.example.ogloszenia.model.ItemAds;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.QItemAds;
import com.example.ogloszenia.model.QJobPosting;
import com.example.ogloszenia.repository.ItemAdsRepository;
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
public class ItemService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    ItemAdsRepository itemAdsRepository;

    public List<ItemAds> getAllItemAds() {
        return itemAdsRepository.findAll();
    }

    public void addItemAds(ItemAds itemAds) {
        itemAdsRepository.save(itemAds);
    }

    public void editItemAds(ItemAds itemAds, Long id) {
        itemAds.setId(id);
        itemAdsRepository.findById(id)
                .map(__ -> itemAdsRepository.save(itemAds));
    }

    public void deleteItemAds(Long id) {
        Optional.of(itemAdsRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    itemAdsRepository.deleteById(id);
                    return null;
                });

    }

    public Optional<ItemAds> getItemAdsByTitle(String title) {
        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        QItemAds qItemAds = QItemAds.itemAds;
        ItemAds itemAds = query.select(qItemAds)
                .from(qItemAds)
                .where(qItemAds.itemName.eq(title))
                .fetchOne();
        return Optional.ofNullable(itemAds);
    }

}
