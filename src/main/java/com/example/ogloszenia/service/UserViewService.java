package com.example.ogloszenia.service;

import com.example.ogloszenia.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.ogloszenia.OgloszeniaApplication.springContext;

@Service
public class UserViewService {

    private FXMLLoader fxmlLoader;

    @Getter
    @Setter
    private String lastOpenAdTab;

    @Getter
    @Setter
    private User loggedUser;

    public void openAdsViewModal(ActionEvent actionEvent, String viewPath, String adName) throws IOException {
        this.setLastOpenAdTab(adName);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setLocation(getClass().getResource(viewPath));
        Pane layout = fxmlLoader.load();



        Stage newWindow = new Stage();
        newWindow.setTitle(adName);

        Scene secondScene = new Scene(layout);
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);
        newWindow.show();
    }

    public void openMessagesViewModal(ActionEvent actionEvent, String viewPath, String adName) throws IOException {
        this.setLastOpenAdTab(adName);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setLocation(getClass().getResource(viewPath));
        SplitPane layout = fxmlLoader.load();

        Stage newWindow = new Stage();
        newWindow.setTitle(adName);

        Scene secondScene = new Scene(layout);
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);
        newWindow.show();
    }

}
