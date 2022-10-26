package ir.twitter.repository.replayRepositori;

import ir.twitter.entity.ReplayType;
import ir.twitter.entity.Tweet;
import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Replay;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface ReplayRepository extends BaseRepository<Replay, Long> {
    Optional<List<Replay>> getReplayOfTweet(Session session, Long tweetId);
    Optional<List<Replay>> getReplayOfReplay(Session session, Long replayId);
    ReplayType checkReplayType(Session session , Long replayId);

}
