package com.example.ogloszenia.service;

import com.example.ogloszenia.model.Adress;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.AdressRepository;
import com.example.ogloszenia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    public List<Adress> getAllAddresses() {
        return adressRepository.findAll();
    }


    public void addAdress(Adress adress) {
        System.out.println("ADDING ADRESS");
        adressRepository.save(adress);
    }
    public void deleteAdress(Long id) {
        Optional.of(adressRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    adressRepository.deleteById(id);
                    return null;
                });
    }
    public void editAdress(Adress adress, Long id) {
        adress.setId(id);
        adressRepository.findById(id)
                .map(__ -> adressRepository.save(adress));
    }
}
