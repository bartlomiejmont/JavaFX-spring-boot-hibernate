package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.HousingAds;
import com.example.ogloszenia.model.ItemAds;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.RentalAds;
import com.example.ogloszenia.service.AdsService;
import com.example.ogloszenia.service.UserViewService;
import com.example.ogloszenia.type.HousingType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AdsController implements Initializable {

    @FXML
    private AnchorPane app;

    @FXML
    private VBox VBOX;


    @FXML
    private TextField titleTF;

    @FXML
    private TextField descriptionTF;


    @Autowired
    UserViewService userViewService;

    @Autowired
    AdsService adsService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(userViewService.getLastOpenAdTab().equals("JOBS")){
            initializeJobs();
        }
        if(userViewService.getLastOpenAdTab().equals("ITEMS")){
            initializeItems();
        }
        if(userViewService.getLastOpenAdTab().equals("HOUSES")){
            initializeHouses();
        }
        if(userViewService.getLastOpenAdTab().equals("RENTALS")){
            initializeRentals();
        }
    }

    public void postAnAd(ActionEvent actionEvent) {
        if(userViewService.getLastOpenAdTab().equals("JOBS")){
            JobPosting jobPosting = new JobPosting(userViewService.getLoggedUser(),titleTF.getText(),descriptionTF.getText(),2000,3000);
            adsService.addJobPosting(jobPosting);
            VBOX.getChildren().remove(0,VBOX.getChildren().size());
            initializeJobs();
        }
        if(userViewService.getLastOpenAdTab().equals("ITEMS")){
            ItemAds itemAds = new ItemAds(userViewService.getLoggedUser(),titleTF.getText(),descriptionTF.getText(),50);
            adsService.addItemAd(itemAds);
            VBOX.getChildren().remove(0,VBOX.getChildren().size());
            initializeItems();
        }
        if(userViewService.getLastOpenAdTab().equals("HOUSES")){
            HousingAds housingAds = new HousingAds(userViewService.getLoggedUser(),titleTF.getText(),descriptionTF.getText(), HousingType.RENT);
            adsService.addHousingAd(housingAds);
            VBOX.getChildren().remove(0,VBOX.getChildren().size());
            initializeHouses();
        }
        if(userViewService.getLastOpenAdTab().equals("RENTALS")){
            RentalAds rentalAds = new RentalAds(userViewService.getLoggedUser(),titleTF.getText(),descriptionTF.getText(),20);
            adsService.addRentalAd(rentalAds);
            VBOX.getChildren().remove(0,VBOX.getChildren().size());
            initializeRentals();
        }
    }

    private void initializeJobs(){
        List<JobPosting> jobPostings = adsService.getAllJobPostings();
        jobPostings.forEach(job ->{
            Text jobTitle = new Text(job.getJobTitle());
            jobTitle.setUnderline(true);
            VBOX.getChildren().addAll(jobTitle, new Text(job.getDescription()),
                    new Text(job.getMinSalary() +"-"+ job.getMaxSalary()));
        });
    }

    private void initializeItems(){
        List<ItemAds> itemAds = adsService.getAllItemAds();
        itemAds.forEach(ad ->{
            Text itemTitle = new Text(ad.getItemName());
            itemTitle.setUnderline(true);
            VBOX.getChildren().addAll(itemTitle, new Text(ad.getDescription()),
                    new Text(String.valueOf(ad.getPrice())+" zł"));
        });
    }

    private void initializeHouses(){
        List<HousingAds> housingAds = adsService.getAllHousingAds();
        housingAds.forEach(ad ->{
            Text houseTitle = new Text(ad.getTitle());
            houseTitle.setUnderline(true);
            VBOX.getChildren().addAll(houseTitle, new Text(ad.getDescription()),
                    new Text(String.valueOf(ad.getPrice())+" zł"));
        });
    }
    private void initializeRentals(){
        List<RentalAds> rentalAds = adsService.getAllRentalsAds();
        rentalAds.forEach(ad ->{
            Text rentalTitle = new Text(ad.getPostingTitle());
            rentalTitle.setUnderline(true);
            VBOX.getChildren().addAll(rentalTitle, new Text(ad.getDescription()),
                    new Text(String.valueOf(ad.getCostPerDay())+" zł per day"));
        });
    }

}
