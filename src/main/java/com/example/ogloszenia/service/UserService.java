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
import java.util.Optional;

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

    public void addUser(User user){
        userRepository.save(user);
    }

    public void editUser(User user ,Long id) {
        userRepository.findById(id)
                .map(__ -> userRepository.save(user));
    }

    public void deleteUser(Long id){
         Optional.of(userRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    userRepository.deleteById(id);
                    return null;
                });

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

}
