package com.example.ogloszenia.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.ogloszenia.OgloszeniaApplication.springContext;

@Service
public class UserViewService {

    private FXMLLoader fxmlLoader;

    public void openAdsViewModal(ActionEvent actionEvent, String viewPath) throws IOException {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setLocation(getClass().getResource(viewPath));
        Pane layout = fxmlLoader.load();

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
