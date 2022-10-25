package ir.twitter.service.followingService;

import ir.twitter.connection.SessionFactoryProvider;
import ir.twitter.entity.Account;
import ir.twitter.entity.Follower;
import ir.twitter.entity.Following;
import ir.twitter.repository.followerRepository.FollowerRepositoryImpl;
import ir.twitter.repository.followingRepository.FollowingRepositoryImpl;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class FollowingServiceImpl implements FollowingService {
    private final FollowingRepositoryImpl FOLLOWING_REPOSITORY = new FollowingRepositoryImpl();
    private final FollowerRepositoryImpl FOLLOWER_REPOSITORY = new FollowerRepositoryImpl();

    @Override
    public void followSomeone(Account mainAccount, Account followed) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                FOLLOWING_REPOSITORY.save(session, new Following(mainAccount, followed));
                FOLLOWER_REPOSITORY.save(session, new Follower(followed, mainAccount));
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
                FOLLOWING_REPOSITORY.delete(session, new Following(mainAccount, following));
                FOLLOWER_REPOSITORY.delete(session, new Follower(following, mainAccount));
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
            return Optional.of(FOLLOWING_REPOSITORY.findAll(session, new Following(account, null)).
                    orElseThrow().stream().map(Following::getFollowing).toList());
        } catch (Exception e) {
            throw e;
        }
    }
}
