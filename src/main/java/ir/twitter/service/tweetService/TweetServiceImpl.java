package ir.twitter.service.tweetService;

import ir.twitter.utility.ApplicationContext;
import ir.twitter.utility.SessionFactoryProvider;
import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.List;

public class TweetServiceImpl implements TweetService {


    @Override
    public void addTweet(Tweet tweet) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getTweetRepository().save(session, tweet);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void editTweet(Tweet tweet) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getTweetRepository().update(session, tweet);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void removeTweet(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getTweetRepository().delete(session, id);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public List<Tweet> showAllTweetOfAnAccount(Long account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getTweetRepository().findAll(session, account).orElseThrow();
        }
    }

    @Override
    public List<Tweet> showAllTweet() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getTweetRepository().showAll(session).orElseThrow();
        }
    }

    @Override
    public List<UsernameTweetDto> showAllTweetDTO() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getTweetRepository().showAllTweetDTO(session);
        }
    }

    @Override
    public Tweet findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getTweetRepository().findById(session, id).orElseThrow();
        }
    }
}