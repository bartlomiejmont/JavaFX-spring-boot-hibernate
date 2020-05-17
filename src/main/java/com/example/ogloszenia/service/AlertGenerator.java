package com.example.ogloszenia.service;

import javafx.scene.control.Alert;
import org.springframework.stereotype.Service;

@Service
public class AlertGenerator {
    public void generateAlert(Exception e){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(e.getMessage());
        a.show();
    }
}
