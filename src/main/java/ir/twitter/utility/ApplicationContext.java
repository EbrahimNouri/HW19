package ir.twitter.utility;

import ir.twitter.repository.likeRepository.LikeRepositoryImpl;
import ir.twitter.service.accountService.AccountServiceImpl;
import ir.twitter.service.followerService.FollowerServiceImpl;
import ir.twitter.service.likeService.LikeServiceImpl;
import ir.twitter.service.replayService.ReplayServiceImpl;
import ir.twitter.service.tweetService.TweetServiceImpl;

public class ApplicationContext {
    private ApplicationContext(){}

    private static final AccountServiceImpl ACCOUNT_SERVICE = new AccountServiceImpl();
    private static final FollowerServiceImpl FOLLOWER_SERVICE = new FollowerServiceImpl();
    private static final FollowerServiceImpl FOLLOWING_SERVICE = new FollowerServiceImpl();
    private static final LikeServiceImpl LIKE_SERVICE = new LikeServiceImpl();
    private static final ReplayServiceImpl REPLAY_SERVICE = new ReplayServiceImpl();
    private static final TweetServiceImpl TWEET_SERVICE = new TweetServiceImpl();

    public static AccountServiceImpl getAccountService() {
        return ACCOUNT_SERVICE;
    }

    public static FollowerServiceImpl getFollowerService() {
        return FOLLOWER_SERVICE;
    }

    public static FollowerServiceImpl getFollowingService() {
        return FOLLOWING_SERVICE;
    }

    public static LikeServiceImpl getLikeService() {
        return LIKE_SERVICE;
    }

    public static ReplayServiceImpl getReplayService() {
        return REPLAY_SERVICE;
    }

    public static TweetServiceImpl getTweetService() {
        return TWEET_SERVICE;
    }
}
