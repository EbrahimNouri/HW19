package ir.twitter.repository.tweetRepository;

import ir.twitter.dto.UsernameTweet;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TweetRepositoryImpl implements TweetRepository {

    public void save(Session session, Tweet tweet) {
        session.save(tweet);
    }

    @Override
    public Optional<Tweet> find(Session session, Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Tweet>> findAll(Session session, Long aLong) {
        return Optional.ofNullable(session.createQuery("from Tweet").getResultList());
    }

    @Override
    public void update(Session session, Tweet tweet) {
        session.update(tweet);
    }


    public Optional<Tweet> findBYId(Session session, Long id) {
        return Optional.ofNullable(session.find(Tweet.class, id));
    }


    public void delete(Session session, Long id) {

        String hql = "delete from Tweet a where a.id =:id";

        session.createQuery(hql).setParameter("id", id).executeUpdate();

    }

    @Override
    public Optional<List<Tweet>> showAll(Session session) {
        return Optional.ofNullable(session.createQuery("from Tweet ", Tweet.class).getResultList());
    }

    @Override
    public Optional<List<UsernameTweet>> showAllTweetDTO(Session session) {
        return Optional.ofNullable
                (session.createQuery
                        ("select t.account.userName, t.message, count(t.like.size) from Tweet t join fetch Replay ",
                                UsernameTweet.class).getResultList());
    }
}
