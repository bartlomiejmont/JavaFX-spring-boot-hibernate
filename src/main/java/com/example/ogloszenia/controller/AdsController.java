package com.example.ogloszenia.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AdsController implements Initializable {

    @FXML
    private VBox VBOX;

    private VBox itemVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VBox itemVBox = new VBox();
        itemVBox.getChildren().addAll(new Text("Title"), new Text("Price"));
        VBOX.getChildren().addAll(itemVBox);
    }
}
