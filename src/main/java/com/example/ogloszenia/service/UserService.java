package com.example.ogloszenia.service;

import com.example.ogloszenia.model.QUser;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

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

    public Optional<User> getUserById(Long id) {
       return userRepository.findById(id);
    }

    public boolean isPassMatchingToUser(String login, String pass){
        Optional<User> user = getUserByLogin(login);

        return user.map(u -> pass.equals(u.getPassword())).orElse(false);
    }

}
