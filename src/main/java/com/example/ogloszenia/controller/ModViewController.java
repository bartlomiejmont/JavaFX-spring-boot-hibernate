package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.HousingAds;
import com.example.ogloszenia.model.ItemAds;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.RentalAds;
import com.example.ogloszenia.service.AdsService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ModViewController implements Initializable {

    @FXML
    private VBox mainVBox;

    @FXML
    private ScrollPane SP;

    @Autowired
    private AdsService adsService;

    private void refresh(){
        List<JobPosting> jobPostings = adsService.getAllJobPostings();
        List<ItemAds> itemAds = adsService.getAllItemAds();
        List<HousingAds> housingAds = adsService.getAllHousingAds();
        List<RentalAds> rentalAds = adsService.getAllRentalsAds();

        mainVBox.getChildren().remove(0,mainVBox.getChildren().size());


        jobPostings.forEach( ad -> {
            Button button = new Button("X");
            button.setOnAction( actionEvent -> {
                adsService.deleteJobPosting(ad.getId());
                refresh();
            });
            mainVBox.getChildren().addAll(new HBox(
                    new Text(ad.getJobTitle()),
                    button
            ));
        });
        itemAds.forEach( ad -> {
            Button button = new Button("X");
            button.setOnAction( actionEvent -> {
                adsService.deleteItemAd(ad.getId());
                refresh();
            });
            mainVBox.getChildren().addAll(new HBox(
                    new Text(ad.getItemName()),
                    button
            ));
        });
        housingAds.forEach( ad -> {
            Button button = new Button("X");
            button.setOnAction( actionEvent -> {
                adsService.deleteHousingAd(ad.getId());
                refresh();
            });
            mainVBox.getChildren().addAll(new HBox(
                    new Text(ad.getTitle()),
                    button
            ));
        });
        rentalAds.forEach( ad -> {
            Button button = new Button("X");
            button.setOnAction( actionEvent -> {
                adsService.deleteRentalAd(ad.getId());
                refresh();
            });
            mainVBox.getChildren().addAll(new HBox(
                    new Text(ad.getPostingTitle()),
                    button
            ));
        });
        SP.setContent(mainVBox);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       refresh();

    }


}
