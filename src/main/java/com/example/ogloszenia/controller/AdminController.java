package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import com.example.ogloszenia.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AdminController implements Initializable {

    @Autowired
    private UserService userService;

    public void usersClick(ActionEvent actionEvent) {

        userService.openUsersWindow(actionEvent);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void jobsClick(ActionEvent actionEvent) throws IOException {
        userService.openTableViewModal(actionEvent);
    }
}
