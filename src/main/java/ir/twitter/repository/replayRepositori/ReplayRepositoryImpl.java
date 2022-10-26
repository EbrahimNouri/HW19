package ir.twitter.repository.replayRepositori;

import ir.twitter.entity.Replay;
import ir.twitter.entity.ReplayType;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ReplayRepositoryImpl implements ReplayRepository {

    public void save(Session session, Replay replay) {
        session.save(replay);
    }

    public Optional<Replay> find(Session session, Long id) {
        return Optional.ofNullable(session.find(Replay.class, id));
    }

    @Override
    public void update(Session session, Replay replay) {
        session.update(replay);
    }

    @Override
    public void delete(Session session, Long comment) {
        session.delete(comment);
    }


    @Override
    public Optional<List<Replay>> findAll(Session session, Long tweetId) {
        return Optional.ofNullable(session.createQuery("from Replay c where c.tweet.id = :accId", Replay.class)
                .setParameter("accId", tweetId).getResultList());
    }

    @Override
    public Optional<List<Replay>> getReplayOfTweet(Session session, Long tweetId) {
        return Optional.ofNullable(session.createQuery("from Replay c where c.tweet.id = :accId", Replay.class)
                .setParameter("accId", tweetId).getResultList());
    }

    @Override
    public Optional<List<Replay>> getReplayOfReplay(Session session, Long replayId) {
        return Optional.ofNullable(session.createQuery("from Replay c where c.replay.id = :accId", Replay.class)
                .setParameter("accId", replayId).getResultList());
    }

    @Override
    public ReplayType checkReplayType(Session session, Long replayId) {
        return session.createQuery("from Replay r where r.id = :id", Replay.class).setParameter("id", replayId)
                .getSingleResult().getReplayType();
    }
}
