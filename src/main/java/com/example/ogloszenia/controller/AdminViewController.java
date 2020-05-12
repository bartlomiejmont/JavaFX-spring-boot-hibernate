package com.example.ogloszenia.controller;

import com.example.ogloszenia.service.AdminViewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class AdminViewController {

    @Autowired
    AdminViewService adminViewService;

    @FXML
    private Button adminViewBT;

    @FXML
    private Button modViewBT;

    @FXML
    private Button userViewBT;


    public void openTableViewModal(ActionEvent actionEvent) throws IOException {
        adminViewService.openTabPaneViewModal(actionEvent,"/tableView.fxml");
    }

    public void openModModal(ActionEvent actionEvent) throws IOException {
        adminViewService.openPaneViewModal(actionEvent,"/modView.fxml");
    }

    public void openUserModal(ActionEvent actionEvent) throws IOException {
        adminViewService.openPaneViewModal(actionEvent,"/userView.fxml");
    }
}
