package com.example.ogloszenia.service;

import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void printAllUsers (){
        System.out.println(userRepository.findAll());
    }

    public void openUsersWindow(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        StackPane secondaryLayout = new StackPane();

        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        TableView tableView = new TableView();

        TableColumn<Long, User> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<String, User> column2 = new TableColumn<>("Login");
        column2.setCellValueFactory(new PropertyValueFactory<>("login"));

        TableColumn<String, User> column3 = new TableColumn<>("Email");
        column3.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<String, User> column4 = new TableColumn<>("Password");
        column4.setCellValueFactory(new PropertyValueFactory<>("password"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        tableView.getItems().addAll(userRepository.findAll());


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        newWindow.setScene(scene);

        newWindow.show();
    }

}
