package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.User;
import com.example.ogloszenia.service.UserService;
import com.example.ogloszenia.type.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
    private TextField userIdTF;

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
//        System.out.println(userService.getAllUsers());
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        userLoginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        userPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTableView.getItems().addAll(userService.getAllUsers());

        userTableView.setRowFactory( tv -> {
            TableRow<User> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty()) {
                    User rowData = row.getItem();
                    replaceTextFields(rowData);
//                    System.out.println(rowData);
                }
            });
            return row ;
        });
    }

    private void replaceTextFields(User rowData) {
        this.userEmailTF.setText(rowData.getEmail());
        this.userIdTF.setText(String.valueOf(rowData.getId()));
        this.userLoginTF.setText(rowData.getLogin());
        this.userPasswordTF.setText(rowData.getPassword());
        this.userTypeTF.setText(String.valueOf(rowData.getType()));
    }

    public void addClick(ActionEvent actionEvent) {
        userService.addUser(getUserFromTF());
        tableViewRefresh();
    }

    public void deleteClick(ActionEvent actionEvent) {

    }

    public void editClick(ActionEvent actionEvent) {

    }

    private User getUserFromTF(){
        User user = new User(userLoginTF.getText(),userEmailTF.getText(),userPasswordTF.getText(), UserType.valueOf(userTypeTF.getText()));
        return user;
    }

    private void tableViewRefresh (){
        userTableView.getItems().removeAll(userTableView.getItems());
        userTableView.getItems().addAll(userService.getAllUsers());
    }
}
