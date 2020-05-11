package com.example.ogloszenia.controller;

import com.example.ogloszenia.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ogloszenia.OgloszeniaApplication.springContext;

@Controller
public class LoginController implements Initializable {

    @Autowired
    private UserService userService;


    private FXMLLoader fxmlLoader;


    @FXML
    private Button loginButton;

    @FXML
    public TextField usernameTextBox;

    @FXML
    public PasswordField passwordTextBox;


    public void loginClick(ActionEvent actionEvent) throws IOException {

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/userView.fxml"));
        Parent rootNode = fxmlLoader.load();
        Scene adminScene = new Scene(rootNode);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(adminScene);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}