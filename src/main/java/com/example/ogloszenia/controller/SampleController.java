package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {

    @Autowired
    private UserRepository repository;


    @FXML
    private Label label;

    public void buttonClicked(ActionEvent actionEvent) {
        System.out.println("Test");
        repository.save(new User(1,"stefan","stefan@gmail.com","haslo1"));
    }
}