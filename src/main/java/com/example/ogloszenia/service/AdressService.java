package com.example.ogloszenia.service;

import com.example.ogloszenia.model.Adress;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.AdressRepository;
import com.example.ogloszenia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    public List<Adress> getAllAddresses() {
        return adressRepository.findAll();
    }


}
