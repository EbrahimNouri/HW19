package ir.twitter.repository.tweetRepository;

import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;
import org.hibernate.id.enhanced.NoopOptimizer;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface TweetRepository extends BaseRepository<Tweet, Long> {
    Optional<List<Tweet>> showAll(Session session);
    List<UsernameTweetDto> showAllTweetDTO(Session session);

    Optional<Tweet> findById(Session session ,Long id);
}
