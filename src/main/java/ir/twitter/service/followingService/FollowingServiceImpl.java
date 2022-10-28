package ir.twitter.service.followingService;

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

public class FollowingServiceImpl implements FollowingService {

    @Override
    public void followSomeone(Account mainAccount, Account followed) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                ApplicationContext.getFollowingRepository().save(session, new Following(mainAccount, followed));
                ApplicationContext.getFollowerRepository().save(session, new Follower(followed, mainAccount));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void unfollowSomeone(Account mainAccount, Account following) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                ApplicationContext.getFollowingRepository().delete(session, new Following(mainAccount, following));
                ApplicationContext.getFollowerRepository().delete(session, new Follower(following, mainAccount));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Optional<List<Account>> showAllFollowing(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return Optional.of(ApplicationContext.getFollowingRepository().findAll(session, new Following(account, null)).
                    orElseThrow().stream().map(Following::getFollowing).toList());
        }
    }
}
