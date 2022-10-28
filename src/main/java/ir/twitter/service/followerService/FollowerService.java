package ir.twitter.service.followerService;

import ir.twitter.entity.Account;

import java.util.List;
import java.util.Optional;

public interface FollowerService {

    void addFollowers(Account mainAccount, Account follower);
    void removeFollower(Account mainAccount, Account follower);
    Optional<List<Account>> showAllFollowers(Account mainAccount);
}
