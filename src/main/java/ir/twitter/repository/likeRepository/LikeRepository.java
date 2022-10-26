package ir.twitter.repository.likeRepository;

import ir.twitter.entity.Tweet;
import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Like;
import ir.twitter.entity.LikeId;
import org.hibernate.Session;

public interface LikeRepository extends BaseRepository<Like, Like> {
    Long countOfLike(Session session, Long tweetId);
}
