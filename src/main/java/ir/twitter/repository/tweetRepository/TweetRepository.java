package ir.twitter.repository.tweetRepository;

import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends BaseRepository<Tweet, Long> {
    Optional<List<Tweet>> showAll(Session session);
}
