package com.example.ogloszenia.service;

import com.example.ogloszenia.model.QUser;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.example.ogloszenia.OgloszeniaApplication.springContext;

@Service
@RequiredArgsConstructor
public class UserService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    private FXMLLoader fxmlLoader;

    public void printAllUsers() {
        System.out.println(userRepository.findAll());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void editUser(User user, Long id) {
        user.setId(id);
        userRepository.findById(id)
                .map(__ -> userRepository.save(user));
    }

    public void deleteUser(Long id) {
        Optional.of(userRepository.existsById(id))
                .filter(exist -> exist)
                .map(__ -> {
                    userRepository.deleteById(id);
                    return null;
                });

    }

    public Optional<User> getUserByLogin(String login) {
        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        QUser qUser = QUser.user;
        User user = query.select(qUser)
                .from(qUser)
                .where(qUser.login.eq(login))
                .fetchOne();
        return Optional.ofNullable(user);
    }

    public boolean isPassMatchingToUser(String login, String pass){
        Optional<User> user = getUserByLogin(login);

        return user.map(u -> pass.equals(u.getPassword())).orElse(false);
    }

    public void openTableViewModal(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

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
