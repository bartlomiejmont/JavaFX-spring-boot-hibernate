package com.example.ogloszenia.service;

import com.example.ogloszenia.type.UserType;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.example.ogloszenia.OgloszeniaApplication.springContext;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private FXMLLoader fxmlLoader;

    public void printAllUsers (){
        System.out.println(userRepository.findAll());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void openTableViewModal(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/tableView.fxml"));
        TabPane layout = fxmlLoader.load();

        Stage newWindow = new Stage();

        Scene secondScene = new Scene(layout);
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);
        newWindow.show();

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

        TableColumn<UserType, User> column5 = new TableColumn<>("Type");
        column5.setCellValueFactory(new PropertyValueFactory<>("type"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);

        tableView.getItems().addAll(userRepository.findAll());


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        newWindow.setScene(scene);

        newWindow.show();
    }

}
