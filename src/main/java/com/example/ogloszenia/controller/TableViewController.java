package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.Adress;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.service.AdressService;
import com.example.ogloszenia.service.AlertGenerator;
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
    @Autowired
    AlertGenerator alertGenerator;
    @Autowired
    AdressService adressService;

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

    @FXML
    private TextField adressFlatNumberTF;

    @FXML
    private TextField adressCityTF;

    @FXML
    private TextField adressIdTF;

    @FXML
    private TextField adressStreetTF;

    @FXML
    private TextField adressUserIdTF;

    @FXML
    private Button adressAddBT;

    @FXML
    private Button adressDeleteBT;

    @FXML
    private Button adressEditBT;

    @FXML
    private TableView adressTableView;

    @FXML
    private TableColumn<?, ?> adressIdColumn;

    @FXML
    private TableColumn<?, ?> adressUserIdColumn;

    @FXML
    private TableColumn<?, ?> adressCityColumn;

    @FXML
    private TableColumn<?, ?> adressStreetColumn;

    @FXML
    private TableColumn<?, ?> adressFlatNumberColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(userService.getAllUsers());
            userInitialize();
            adressInitialize();
    }

    private void adressInitialize() {
        adressIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        adressCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        adressStreetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        adressUserIdColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        adressFlatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flatNumber"));
        adressTableView.getItems().addAll(adressService.getAllAddresses());

        adressTableView.setRowFactory( tv -> {
            TableRow<Adress> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty()) {
                    Adress rowData = row.getItem();
                    replaceAdressTextFields(rowData);
                }
            });
            return row ;
        });
    }

    private void replaceAdressTextFields(Adress rowData) {
        this.adressIdTF.setText(String.valueOf(rowData.getId()));
        this.adressCityTF.setText(rowData.getCity());
        this.adressStreetTF.setText(rowData.getStreet());
        this.adressFlatNumberTF.setText(String.valueOf(rowData.getFlatNumber()));
        try {
            this.adressUserIdTF.setText(String.valueOf(rowData.getUser().getId()));
        }
        catch (Exception e) {

        }
    }

    private void userInitialize(){
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
                    replaceUserTextFields(rowData);
                }
            });
            return row ;
        });
    }

    private void replaceUserTextFields(User rowData) {
        this.userEmailTF.setText(rowData.getEmail());
        this.userIdTF.setText(String.valueOf(rowData.getId()));
        this.userLoginTF.setText(rowData.getLogin());
        this.userPasswordTF.setText(rowData.getPassword());
        this.userTypeTF.setText(String.valueOf(rowData.getType()));
    }

    public void addUserClick(ActionEvent actionEvent) {
        userService.addUser(getUserFromTF());
        tableViewRefresh();
    }

    public void deleteUserClick(ActionEvent actionEvent) {
        userService.deleteUser(Long.valueOf(userIdTF.getText()));
        tableViewRefresh();
    }

    public void editUserClick(ActionEvent actionEvent) {
        userService.editUser(getUserFromTF(),Long.valueOf(userIdTF.getText()));
        tableViewRefresh();
    }

    private User getUserFromTF(){
        User user = new User(userLoginTF.getText(),userEmailTF.getText(),userPasswordTF.getText(), UserType.valueOf(userTypeTF.getText()));
        return user;
    }

    private void tableViewRefresh (){
        userTableView.getItems().removeAll(userTableView.getItems());
        userTableView.getItems().addAll(userService.getAllUsers());
        adressTableView.getItems().removeAll(adressTableView.getItems());
        adressTableView.getItems().addAll(adressService.getAllAddresses());
    }

    public void addAdressClick(ActionEvent actionEvent) {
        adressService.addAdress(getAdressFromTF());
        changeUsersAdress(adressService.getAllAddresses().get(adressService.getAllAddresses().size()-1));
        tableViewRefresh();
    }

    public void deleteAdressClick(ActionEvent actionEvent) {
        adressService.deleteAdress(Long.valueOf(adressIdTF.getText()));
        tableViewRefresh();
    }

    public void editAdressClick(ActionEvent actionEvent) {

        adressService.editAdress(getAdressFromTF(),Long.valueOf(adressIdTF.getText()));
        changeUsersAdress(adressService.getAllAddresses().get((int) (Long.valueOf(adressIdTF.getText())-1)));
        tableViewRefresh();
    }

    private Adress getAdressFromTF(){
        Adress adress = new Adress(adressCityTF.getText(),adressStreetTF.getText(),adressFlatNumberTF.getText());
        return adress;
    }

    private void changeUsersAdress(Adress adress) {
        if(!adressUserIdTF.getText().equals("")){
            try {
                User user = userService.getUserById(Long.valueOf(adressUserIdTF.getText())).get();
                user.setAdress(adress);
                userService.editUser(user,Long.valueOf(adressUserIdTF.getText()));
            }
            catch (Exception e) {
                alertGenerator.generateAlert(e);
            }
        }
    }
}
