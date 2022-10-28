import ir.twitter.entity.Account;
import ir.twitter.service.accountService.AccountServiceImpl;
import ir.twitter.service.followerService.FollowerServiceImpl;
import ir.twitter.service.followingService.FollowingServiceImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test one by one is work
public class FollowingFollowerTest {

    private static final AccountServiceImpl ACCOUNT_SERVICE = new AccountServiceImpl();
    private final FollowerServiceImpl FOLLOWER_SERVICE = new FollowerServiceImpl();
    private static final FollowingServiceImpl FOLLOWING_SERVICE = new FollowingServiceImpl();

    private static Account account1;
    private static Account account2;

    @BeforeAll
    static void createPretest() {
        account1 = new Account(null, "ebrahim1", "ebi1@gmail.com", "123456789", null,
                null, null, null, null);
        account2 = new Account(null, "ebrahim2", "ebi2@gmail.com", "123456789", null,
                null, null, null, null);
    }

    @BeforeEach
    void addFlower() {
        ACCOUNT_SERVICE.addAccount(account1);
        ACCOUNT_SERVICE.addAccount(account2);
        FOLLOWING_SERVICE.followSomeone(account1, account2);
    }

    @Order(2)
    @Test
    void getFlowerOfAnAccount() {
        Account test1 = FOLLOWING_SERVICE.showAllFollowing(account1).orElseThrow().get(0);
        Account test2 = FOLLOWER_SERVICE.showAllFollowers(account2).orElseThrow().get(0);
        assertEquals(account2.getUserName(), test1.getUserName());
        assertEquals(account1.getUserName(), test2.getUserName());
    }

    @Order(1)
    @Test
    void getUnfollowTest() {
        FOLLOWING_SERVICE.unfollowSomeone(account1, account2);
        assertEquals(0, FOLLOWING_SERVICE.showAllFollowing(account1).get().size());
        assertEquals(0, FOLLOWING_SERVICE.showAllFollowing(account2).get().size());
    }

    @AfterAll
    static void remove() {
        FOLLOWING_SERVICE.unfollowSomeone(account1, account2);
        ACCOUNT_SERVICE.removeAccount(account1);
        ACCOUNT_SERVICE.removeAccount(account2);
    }
}
