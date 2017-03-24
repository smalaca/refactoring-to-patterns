package com.smalaca.designpatterns.example.visitor.message.send;

import com.smalaca.designpatterns.example.visitor.message.domain.Email;
import com.smalaca.designpatterns.example.visitor.message.domain.Message;
import com.smalaca.designpatterns.example.visitor.message.domain.Sms;
import com.smalaca.designpatterns.example.visitor.message.domain.Tweet;
import com.smalaca.designpatterns.example.visitor.message.domain.UnsupportedMessageException;
import com.smalaca.designpatterns.example.visitor.message.domain.repository.MessageRepository;

public class Messanger {
    private final MessageRepository messageRepository;

    public Messanger(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    void send(Message message) {
        if (message instanceof Email) {
            sendAnEmail((Email) message);
        } else if (message instanceof Tweet) {
            sendTweet((Tweet) message);
        } else if (message instanceof Sms) {
            sendSms((Sms) message);
        } else {
            throw new UnsupportedMessageException();
        }

        messageRepository.store(message);
    }

    private void sendAnEmail(Email email) {

    }

    private void sendTweet(Tweet tweet) {

    }

    private void sendSms(Sms sms) {

    }
}
