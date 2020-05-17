package com.example.ogloszenia.controller;

import com.example.ogloszenia.service.UserService;
import com.example.ogloszenia.service.UserViewService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class UserViewController implements Initializable {

    @Autowired
    private UserService userService;

    @Autowired
    private UserViewService userViewService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void jobsClick(ActionEvent actionEvent) throws IOException {
        userViewService.openAdsViewModal(actionEvent, "/AdsView.fxml" ,"JOBS");
    }

    public void messagesClick(ActionEvent actionEvent) throws IOException {
    }

    public void itemsClick(ActionEvent actionEvent) throws IOException {
        userViewService.openAdsViewModal(actionEvent, "/AdsView.fxml", "ITEMS");
    }

    public void rentalsClick(ActionEvent actionEvent) throws IOException {
        userViewService.openAdsViewModal(actionEvent, "/AdsView.fxml", "RENTALS");
    }

    public void housesClick(ActionEvent actionEvent) throws IOException {
        userViewService.openAdsViewModal(actionEvent, "/AdsView.fxml", "HOUSES");
    }

    public void opinionsClick(ActionEvent actionEvent) {
    }
}
