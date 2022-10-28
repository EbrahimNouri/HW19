package ir.twitter.service.replayService;

import ir.twitter.utility.ApplicationContext;
import ir.twitter.utility.SessionFactoryProvider;
import ir.twitter.entity.Replay;
import ir.twitter.repository.replayRepositori.ReplayRepositoryImpl;
import org.hibernate.Session;

import java.util.List;

public class ReplayServiceImpl implements ReplayService {



    @Override
    public void addReplay(Replay replay) {
        if (replay.getTweet() != null && replay.getReplay() != null
                | replay.getTweet() == null && replay.getReplay() == null)
            throw new RuntimeException("this replay is invalid");
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getReplayRepository().save(session, replay);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }


    @Override
    public void removeReplay(Replay replay) {

        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getReplayRepository().delete(session, replay.getId());
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void editReplay(Replay replay, String message) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                replay.setComment(message);
                ApplicationContext.getReplayRepository().update(session, replay);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public List<Replay> showAllReplayOfTweet(long tweetId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getReplayRepository().getReplayOfTweet(session, tweetId).orElseThrow();

        }
    }

    @Override
    public List<Replay> showAllReplayOfReplay(long replayId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getReplayRepository().getReplayOfReplay(session, replayId).orElseThrow();

        }
    }
}