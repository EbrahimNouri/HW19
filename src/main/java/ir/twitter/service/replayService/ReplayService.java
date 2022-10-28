package ir.twitter.service.replayService;

import ir.twitter.entity.Replay;
import org.hibernate.Session;

import java.util.List;

public interface ReplayService {
    void addReplay(Replay replay);
    void removeReplay(Replay replay);
    void editReplay(Replay replay, String message);
     List<Replay> showAllReplayOfTweet(long tweetId);
     List<Replay> showAllReplayOfReplay(long replayId);

    }
