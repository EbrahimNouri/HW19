package ir.twitter.service.followingService;

import ir.twitter.entity.Account;
import ir.twitter.entity.Following;

import java.util.List;
import java.util.Optional;

public interface FollowingService {
    void followSomeone(Account mainAccount, Account following);
    void unfollowSomeone(Account mainAccount, Account following);

    Optional<List<Account>> showAllFollowing(Account account);

}
