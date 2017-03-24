package com.smalaca.designpatterns.example.visitor.message.statistics;

import com.smalaca.designpatterns.example.visitor.message.domain.Email;
import com.smalaca.designpatterns.example.visitor.message.domain.Message;
import com.smalaca.designpatterns.example.visitor.message.domain.Sms;
import com.smalaca.designpatterns.example.visitor.message.domain.Statistic;
import com.smalaca.designpatterns.example.visitor.message.domain.Tweet;
import com.smalaca.designpatterns.example.visitor.message.domain.UnsupportedMessageException;
import com.smalaca.designpatterns.example.visitor.message.domain.repository.StatisticsRepository;

public class Statistics {
    private final StatisticsRepository statisticsRepository;

    public Statistics(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    void gather(Message message) {
        Statistic statistic;

        if (message instanceof Email) {
            statistic = gatherFromEmail((Email) message);
        } else if (message instanceof Tweet) {
            statistic = gatherFromTweet((Tweet) message);
        } else if (message instanceof Sms) {
            statistic = gatherFromSms((Sms) message);
        } else {
            throw new UnsupportedMessageException();
        }

        statisticsRepository.store(statistic);
    }

    private Statistic gatherFromEmail(Email email) {
        return null;
    }

    private Statistic gatherFromTweet(Tweet tweet) {
        return null;
    }

    private Statistic gatherFromSms(Sms sms) {
        return null;
    }
}
