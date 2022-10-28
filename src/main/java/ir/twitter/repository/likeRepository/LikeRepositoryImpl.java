package ir.twitter.repository.likeRepository;

import ir.twitter.entity.Like;
import ir.twitter.entity.LikeId;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class LikeRepositoryImpl implements LikeRepository {

    public void save(Session session, Like like) {
        session.save(like);
    }

    @Override
    public Optional<Like> find(Session session, Like likeId) {
        return Optional.ofNullable(session.createQuery(" from Like l where l.tweet.id =:newTweet and l.account = :accId", Like.class)
                .setParameter("newTweet", likeId.getTweet().getId()).setParameter("accId", likeId.getAccount().getId()).list().get(0));
    }

    @Override
    public Optional<List<Like>> findAll(Session session, Like likeId) {

        return Optional.ofNullable(session.createQuery(" from Like l where l.tweet.id =:newTweet and l.account = :accId", Like.class)
                .setParameter("newTweet", likeId.getTweet().getId()).setParameter("accId", likeId.getAccount().getId()).list());

    }

    @Override
    public void update(Session session, Like like) {
        session.update(like);
    }

    @Override
    public void delete(Session session, Like like) {

        String hql = " delete from Like l where l.tweet.id =:id And l.account.id=:Id ";
        session.createQuery(hql).setParameter("id", like.getTweet().getId())
                .setParameter("Id", like.getAccount().getId()).executeUpdate();
    }

@Override
    public Long countOfLike(Session session, Long tweetId){

        return session.createQuery
                        ("select count(l) from Like l where l.tweet.id =: id", Long.class)
                .setParameter("id", tweetId).getSingleResult();
    }
}
