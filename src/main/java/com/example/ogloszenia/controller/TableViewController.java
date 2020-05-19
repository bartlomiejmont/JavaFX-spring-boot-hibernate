package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.Adress;
import com.example.ogloszenia.model.JobPosting;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.service.AdressService;
import com.example.ogloszenia.service.AlertGenerator;
import com.example.ogloszenia.service.JobPostingService;
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
    @Autowired
    JobPostingService jobPostingService;

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

    @FXML
    private TextField maxSalaryTF;

    @FXML
    private TextField jobDescriptionTF;

    @FXML
    private TextField jobTitleTF;

    @FXML
    private TextField minSalaryTF;

    @FXML
    private TextField jobUserLoginTF;

    @FXML
    private TableView jobTableView;

    @FXML
    private TableColumn<?, ?> jobIdColumn;

    @FXML
    private TableColumn<?, ?> jobUserIdColumn;

    @FXML
    private TableColumn<?, ?> jobTitleColumn;

    @FXML
    private TableColumn<?, ?> jobDescriptionColumn;

    @FXML
    private TableColumn<?, ?> jobMinSalaryColumn;

    @FXML
    private TableColumn<?, ?> jobMaxSalaryColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(userService.getAllUsers());
            userInitialize();
            adressInitialize();
            jobPostingInitialize();
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
    private void jobPostingInitialize(){
        jobIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobUserIdColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        jobDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        jobMinSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("minSalary"));
        jobMaxSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("maxSalary"));
        jobTableView.getItems().addAll(jobPostingService.getAllJobPostings());

        jobTableView.setRowFactory( tv -> {
            TableRow<JobPosting> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty()) {
                    JobPosting rowData = row.getItem();
                    replaceJobPostingTextField(rowData);
                }
            });
            return row ;
        });
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
    private void replaceJobPostingTextField(JobPosting jobPosting) {
        this.jobTitleTF.setText(jobPosting.getJobTitle());
        this.jobDescriptionTF.setText(jobPosting.getDescription());
        this.minSalaryTF.setText(String.valueOf(jobPosting.getMinSalary()));
        this.maxSalaryTF.setText(String.valueOf(jobPosting.getMaxSalary()));
        this.jobUserLoginTF.setText(jobPosting.getUser().getLogin());
    }

    private void replaceUserTextFields(User rowData) {
        this.userEmailTF.setText(rowData.getEmail());
        this.userIdTF.setText(String.valueOf(rowData.getId()));
        this.userLoginTF.setText(rowData.getLogin());
        this.userPasswordTF.setText(rowData.getPassword());
        this.userTypeTF.setText(String.valueOf(rowData.getType()));
    }

    public void addUserClick(ActionEvent actionEvent) {
        try {
            userService.addUser(getUserFromTF());
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }

    }

    public void deleteUserClick(ActionEvent actionEvent) {
        try {
            userService.deleteUser(Long.valueOf(userIdTF.getText()));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }

    }

    public void editUserClick(ActionEvent actionEvent) {
        try {
            userService.editUser(getUserFromTF(),Long.valueOf(userIdTF.getText()));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }

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
        jobTableView.getItems().removeAll(jobTableView.getItems());
        jobTableView.getItems().addAll(jobPostingService.getAllJobPostings());
    }

    public void addAdressClick(ActionEvent actionEvent) {
        try {
            adressService.addAdress(getAdressFromTF());
            changeUsersAdress(adressService.getAllAddresses().get(adressService.getAllAddresses().size()-1));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }

    }

    public void deleteAdressClick(ActionEvent actionEvent) {
        try {
            adressService.deleteAdress(Long.valueOf(adressIdTF.getText()));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }

    }

    public void editAdressClick(ActionEvent actionEvent) {
        try {
            adressService.editAdress(getAdressFromTF(),Long.valueOf(adressIdTF.getText()));
            changeUsersAdress(adressService.getAllAddresses().get((int) (Long.valueOf(adressIdTF.getText())-1)));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }
    }

    @FXML
    void addJobClick(ActionEvent event) {
        try {
            jobPostingService.addJobPosting(getJobPostingFromTF());
            changeUsersAdress(adressService.getAllAddresses().get(adressService.getAllAddresses().size()-1));
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }
    }

    @FXML
    void editJobClick(ActionEvent event) {
        try {
            jobPostingService.editJobPosting(getJobPostingFromTF(),jobPostingService.getJobPostingByTitle(jobTitleTF.getText()).get().getId());
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }
    }

    @FXML
    void deleteJobClick(ActionEvent event) {
        try {
            jobPostingService.deleteJobPosting(jobPostingService.getJobPostingByTitle(jobTitleTF.getText()).get().getId());
            tableViewRefresh();
        } catch (Exception e ){
            alertGenerator.generateAlert(e);
        }
    }

    private JobPosting getJobPostingFromTF(){
        try{
            User user = userService.getUserByLogin(jobUserLoginTF.getText()).get();
            try{
                JobPosting jobPosting = new JobPosting(user,jobTitleTF.getText(),jobDescriptionTF.getText(),Long.parseLong(minSalaryTF.getText()),Long.parseLong(maxSalaryTF.getText()));
                return jobPosting;
            } catch (Exception e){
                alertGenerator.generateAlert(e);
            }
        } catch (Exception e){
            alertGenerator.generateAlert(new Exception("User does not exists"));
        }
        return null;
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
