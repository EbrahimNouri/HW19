package ir.twitter.service.followerService;

import ir.twitter.utility.ApplicationContext;
import ir.twitter.utility.SessionFactoryProvider;
import ir.twitter.entity.Account;
import ir.twitter.entity.Follower;
import ir.twitter.entity.Following;
import ir.twitter.repository.followerRepository.FollowerRepositoryImpl;
import ir.twitter.repository.followingRepository.FollowingRepositoryImpl;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class FollowerServiceImpl implements FollowerService {


    @Override
    public void addFollowers(Account mainAccount, Account follower) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getFollowingRepository().save(session, new Following(mainAccount, follower));
                ApplicationContext.getFollowerRepository().save(session, new Follower(follower, mainAccount));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void removeFollower(Account mainAccount, Account follower) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getFollowingRepository().delete(session, new Following(mainAccount, follower));
                ApplicationContext.getFollowerRepository().delete(session, new Follower(follower, mainAccount));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }

    }

    @Override
    public Optional<List<Account>> showAllFollowers(Account mainAccount) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return Optional.of(ApplicationContext.getFollowerRepository().findAll(session, new Follower(mainAccount, null) ).
                    orElseThrow().stream().map(Follower::getFollower).toList());
        }
    }
}
