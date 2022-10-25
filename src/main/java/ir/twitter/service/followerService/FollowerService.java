package ir.twitter.service.followerService;

import ir.twitter.entity.Account;

public interface FollowerService {
    FollowingServiceImpl f

    void addFollowers(Account mainAccount, Account follower);
    void removeFollower(Account mainAccount, Account follower);
    void showAllFollowers(Account mainAccount, Account follower);
}
