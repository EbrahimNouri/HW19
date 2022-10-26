package ir.twitter.service.replayService;

import ir.twitter.connection.SessionFactoryProvider;
import ir.twitter.entity.Replay;
import ir.twitter.entity.ReplayType;
import ir.twitter.repository.replayRepositori.ReplayRepositoryImpl;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ReplayServiceImpl implements ReplayService {

    private final ReplayRepositoryImpl REPLAY_REPOSITORY = new ReplayRepositoryImpl();

    // IF in replay tweet has been null and replay notnull this replay for a replay and if
    // replay has been null and tweet be null this replay for a tweet
    @Override
    public void addReplay(Replay replay) {
        if (replay.getTweet() != null && replay.getReplay() != null
                | replay.getTweet() == null && replay.getReplay() == null)
            throw new RuntimeException("this replay is invalid");
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                REPLAY_REPOSITORY.save(session, replay);
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
                REPLAY_REPOSITORY.delete(session, replay.getId());
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
                REPLAY_REPOSITORY.update(session, replay);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public List<Replay> showAllReplay(long tweetId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            if (REPLAY_REPOSITORY.checkReplayType(session, tweetId) == ReplayType.TWEET) {
                return REPLAY_REPOSITORY.getReplayOfTweet(session, tweetId).orElseThrow();
            } else {
                return REPLAY_REPOSITORY.getReplayOfReplay(session, tweetId).orElseThrow();
            }
        }
    }
}