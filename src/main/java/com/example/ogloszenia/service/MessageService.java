package com.example.ogloszenia.service;

import com.example.ogloszenia.model.Message;
import com.example.ogloszenia.model.QMessage;
import com.example.ogloszenia.model.QUser;
import com.example.ogloszenia.model.User;
import com.example.ogloszenia.repository.MessageRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserViewService userViewService;

    public Optional<List<Message>> getAllUsersMessages(){
        User user = userViewService.getLoggedUser();

        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        QMessage qMessage = QMessage.message;

        List<Message> messages = new ArrayList<>(query.select(qMessage)
                .from(qMessage)
                .where(qMessage.userReceivingId.eq(user.getId()))
                .fetch());
        return Optional.ofNullable(messages);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

}
