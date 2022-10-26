package ir.twitter.service.tweetService;

import ir.twitter.connection.SessionFactoryProvider;
import ir.twitter.dto.UsernameTweet;
import ir.twitter.entity.Tweet;
import ir.twitter.repository.tweetRepository.TweetRepositoryImpl;
import org.hibernate.Session;

import java.util.List;

public class TweetServiceImpl implements TweetService {

    private final TweetRepositoryImpl TWEET_REPOSITORY = new TweetRepositoryImpl();

    @Override
    public void addTweet(Tweet tweet) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                TWEET_REPOSITORY.save(session, tweet);
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
                TWEET_REPOSITORY.update(session, tweet);
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
                TWEET_REPOSITORY.delete(session, id);
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
                return TWEET_REPOSITORY.findAll(session, account).orElseThrow();
        }
    }

    @Override
    public List<Tweet> showAllTweet() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            return TWEET_REPOSITORY.showAll(session).orElseThrow();
        }
    }

    @Override
    public List<UsernameTweet> showAllTweetDTO() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return TWEET_REPOSITORY.showAllTweetDTO(session).orElseThrow();
        }
    }
}