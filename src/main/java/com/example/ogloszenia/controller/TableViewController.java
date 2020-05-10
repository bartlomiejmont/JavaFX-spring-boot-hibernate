package com.example.ogloszenia.controller;

import com.example.ogloszenia.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class TableViewController implements Initializable {

    @Autowired
    UserService userService;

    @FXML
    private TableColumn<?, ?> userLoginColumn;

    @FXML
    private TableColumn<?, ?> userEmailColumn;

    @FXML
    private TableColumn<?, ?> userPasswordColumn;

    @FXML
    private TableColumn<?, ?> userTypeColumn;

    @FXML
    private TableColumn<?, ?> userIdColumn;

    @FXML
    private TextField userLoginTF;

    @FXML
    private TextField userEmailTF;

    @FXML
    private TextField userPasswordTF;

    @FXML
    private TextField userTypeTF;

    @FXML
    private Button userAddBT;

    @FXML
    private Button userDeleteBT;

    @FXML
    private Button userEditBT;

    @FXML
    private TableView userTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(userService.getAllUsers());
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        userLoginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        userPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTableView.getItems().addAll(userService.getAllUsers());
    }
}
