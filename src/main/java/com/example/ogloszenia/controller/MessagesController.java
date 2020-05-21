package com.example.ogloszenia.controller;

import com.example.ogloszenia.model.Message;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.service.AlertGenerator;
import com.example.ogloszenia.service.MessageService;
import com.example.ogloszenia.service.UserService;
import com.example.ogloszenia.service.UserViewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@Controller
public class MessagesController implements Initializable {

    @Autowired
    private MessageService messageService;

    @Autowired
    private AlertGenerator alertGenerator;

    @Autowired
    private UserService userService;

    @Autowired
    private UserViewService userViewService;

    @FXML
    private VBox yourMessages;

    @FXML
    private ChoiceBox<String> userChoice;

    @FXML
    private TextField titleTF;

    @FXML
    private TextArea contentTA;

    @FXML
    void sendMessage(ActionEvent event) {
        try{
            User userSending = userViewService.getLoggedUser();
            User userReceving = userService.getUserByLogin(userChoice.getValue()).get();
            Message message = new Message(userSending,userReceving,titleTF.getText(),contentTA.getText());
            messageService.addMessage(message);
            alertGenerator.okAlert("Message has been sent");
        } catch (Exception e){
            alertGenerator.generateAlert(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeMessages();
        initializeUsers();
    }

    private void initializeUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> {
            userChoice.getItems().add(user.getLogin());
        });
    }

    private void initializeMessages(){
        if(messageService.getAllUsersMessages().isPresent()){
            List<Message> itemAds = messageService.getAllUsersMessages().get();
            itemAds.forEach(msg ->{
                Text itemTitle = new Text(msg.getTitle());
                itemTitle.setUnderline(true);
                yourMessages.getChildren().addAll(itemTitle, new Text(msg.getContent()));
            });
        }
        else{
            alertGenerator.generateAlert(new Exception("No messages"));
        }
    }
}
