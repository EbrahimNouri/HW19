package ir.twitter.service.likeService;

import ir.twitter.utility.SessionFactoryProvider;
import ir.twitter.entity.Like;
import ir.twitter.repository.likeRepository.LikeRepositoryImpl;
import org.hibernate.Session;

public class LikeServiceImpl implements LikeService {
    private final LikeRepositoryImpl LIKE_REPOSITORY = new LikeRepositoryImpl();

    @Override
    public void makeLike(Like like) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                LIKE_REPOSITORY.save(session, like);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void dislike(Like like) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                LIKE_REPOSITORY.delete(session, like);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Long countOfLikes(Long tweetId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return LIKE_REPOSITORY.countOfLike(session, tweetId);
        }
    }
}
