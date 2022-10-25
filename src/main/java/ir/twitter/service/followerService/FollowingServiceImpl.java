package ir.twitter.service.followerService;

import ir.twitter.connection.SessionFactoryProvider;
import ir.twitter.entity.Account;
import ir.twitter.entity.Follower;
import ir.twitter.entity.Following;
import ir.twitter.repository.followerRepository.FollowerRepositoryImpl;
import ir.twitter.repository.followingRepository.FollowingRepositoryImpl;
import org.hibernate.Session;

public class FollowingServiceImpl implements FollowerService {

    private final FollowingRepositoryImpl FOLLOWING_REPOSITORY = new FollowingRepositoryImpl();
    private final FollowerRepositoryImpl FOLLOWER_REPOSITORY = new FollowerRepositoryImpl();

    @Override
    public void addFollowers(Account mainAccount, Account follower) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                FOLLOWING_REPOSITORY.save(session,new Following(mainAccount, follower));
                FOLLOWER_REPOSITORY.save(session,new Follower(follower, mainAccount));
                session.getTransaction().commit();
            }catch (Exception e){
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
                FOLLOWING_REPOSITORY.delete(session, new Following(mainAccount, follower));
                FOLLOWER_REPOSITORY.delete(session, new Follower(follower, mainAccount));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }

    }

    @Override
    public void showAllFollowers(Account mainAccount, Account follower) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {

            }catch (Exception e){
                throw e;
            }
    }
}
