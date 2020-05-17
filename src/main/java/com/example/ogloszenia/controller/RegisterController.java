package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.User;
import com.example.ogloszenia.service.AlertGenerator;
import com.example.ogloszenia.service.UserService;
import com.example.ogloszenia.type.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    @FXML
    private TextField loginTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField password1TF;

    @FXML
    private TextField password2TF;

    @Autowired
    private UserService userService;
    @Autowired
    private AlertGenerator alertGenerator;

    @FXML
    void register(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(!password1TF.getText().equals(password2TF.getText())){
            alertGenerator.generateAlert(new Exception("Please type same password"));
        }
        else {
            try{
                User user = new User(loginTF.getText(),emailTF.getText(),password1TF.getText(), UserType.USER);
                userService.addUser(user);
                window.close();
            } catch (Exception e){
                alertGenerator.generateAlert(new Exception("Login or Email is already in use"));
            }
        }
    }
}
