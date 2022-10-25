package ir.twitter.repository.followerRepository;

import ir.twitter.entity.Follower;
import ir.twitter.entity.FollowerId;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class FollowerRepositoryImpl implements FollowerRepository{

    public void save(Session session, Follower follower) {
        session.save(follower);
    }

    @Override
    public Optional<Follower> find(Session session, FollowerId followerId) {
        return Optional.ofNullable(session.createQuery("from Follower f where f.account.id = :accId  and f.follower.id = :follId" , Follower.class)
                .setParameter("accId", followerId.getAccount().getId()).setParameter("follId", followerId.getFollower().getId())
                .getResultList().get(0));
    }


    @Override
    public Optional<List<Follower>> findAll(Session session, FollowerId followerId) {
        return Optional.ofNullable(session.createQuery("from Follower f where f.account.id = :accId  and f.follower.id = :follId" , Follower.class)
                .setParameter("accId", followerId.getAccount().getId()).setParameter("follId", followerId.getFollower().getId())
                .getResultList());
    }

    @Override
    public void update(Session session, Follower follower) {
        session.update(follower);
    }

    public void delete(Session session, FollowerId follower) {
        session.delete(follower);
    }
}
