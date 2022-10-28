package ir.twitter.utility;

import ir.twitter.repository.accountRepository.AccountRepositoryImpl;
import ir.twitter.repository.followerRepository.FollowerRepositoryImpl;
import ir.twitter.repository.followingRepository.FollowingRepositoryImpl;
import ir.twitter.repository.likeRepository.LikeRepositoryImpl;
import ir.twitter.repository.replayRepositori.ReplayRepositoryImpl;
import ir.twitter.repository.tweetRepository.TweetRepositoryImpl;
import ir.twitter.service.accountService.AccountServiceImpl;
import ir.twitter.service.followerService.FollowerServiceImpl;
import ir.twitter.service.followingService.FollowingServiceImpl;
import ir.twitter.service.likeService.LikeServiceImpl;
import ir.twitter.service.replayService.ReplayServiceImpl;
import ir.twitter.service.tweetService.TweetServiceImpl;

public class ApplicationContext {
    private ApplicationContext() {
    }

    private static final AccountServiceImpl ACCOUNT_SERVICE = new AccountServiceImpl();
    private static final FollowerServiceImpl FOLLOWER_SERVICE = new FollowerServiceImpl();
    private static final FollowingServiceImpl FOLLOWING_SERVICE = new FollowingServiceImpl();
    private static final LikeServiceImpl LIKE_SERVICE = new LikeServiceImpl();
    private static final ReplayServiceImpl REPLAY_SERVICE = new ReplayServiceImpl();
    private static final TweetServiceImpl TWEET_SERVICE = new TweetServiceImpl();

    private static final AccountRepositoryImpl ACCOUNT_REPOSITORY = new AccountRepositoryImpl();
    private static final FollowerRepositoryImpl FOLLOWER_REPOSITORY = new FollowerRepositoryImpl();
    private static final FollowingRepositoryImpl FOLLOWING_REPOSITORY = new FollowingRepositoryImpl();
    private static final LikeRepositoryImpl LIKE_REPOSITORY = new LikeRepositoryImpl();
    private static final ReplayRepositoryImpl REPLAY_REPOSITORY = new ReplayRepositoryImpl();
    private static final TweetRepositoryImpl TWEET_REPOSITORY = new TweetRepositoryImpl();


    public static AccountServiceImpl getAccountService() {
        return ACCOUNT_SERVICE;
    }

    public static FollowerServiceImpl getFollowerService() {
        return FOLLOWER_SERVICE;
    }

    public static FollowingServiceImpl getFollowingService() {
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

    public static AccountRepositoryImpl getAccountRepository() {
        return ACCOUNT_REPOSITORY;
    }

    public static FollowerRepositoryImpl getFollowerRepository() {
        return FOLLOWER_REPOSITORY;
    }

    public static FollowingRepositoryImpl getFollowingRepository() {
        return FOLLOWING_REPOSITORY;
    }

    public static LikeRepositoryImpl getLikeRepository() {
        return LIKE_REPOSITORY;
    }

    public static ReplayRepositoryImpl getReplayRepository() {
        return REPLAY_REPOSITORY;
    }

    public static TweetRepositoryImpl getTweetRepository() {
        return TWEET_REPOSITORY;
    }
}
