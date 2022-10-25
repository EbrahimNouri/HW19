package ir.twitter.repository.followingRepository;

import ir.twitter.entity.Following;
import ir.twitter.entity.FollowingId;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class FollowingRepositoryImpl implements FollowingRepository{
    @Override
    public void save(Session session, Following following) {
        session.save(following);
    }

    @Override
    public Optional<Following> find(Session session, FollowingId followingId) {
        return Optional.ofNullable(session.createQuery("from Following f where f.account.id = :accId  and f.following.id = :follId" , Following.class)
                .setParameter("accId", followingId.getAccount().getId()).setParameter("follId", followingId.getFollowing().getId())
                .getResultList().get(0));
    }

    @Override
    public Optional<List<Following>> findAll(Session session, FollowingId followingId) {
        return Optional.ofNullable(session.createQuery("from Following f where f.account.id = :accId  and f.following.id = :follId" , Following.class)
                .setParameter("accId", followingId.getAccount().getId()).setParameter("follId", followingId.getFollowing().getId())
                .getResultList());
    }

    @Override
    public void update(Session session, Following following) {
        session.update(following);
    }

    @Override
    public void delete(Session session, FollowingId following) {
        session.delete(following);
    }
}
