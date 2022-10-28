import ir.twitter.entity.Account;
import ir.twitter.entity.Like;
import ir.twitter.entity.Tweet;
import ir.twitter.service.accountService.AccountServiceImpl;
import ir.twitter.service.tweetService.TweetServiceImpl;
import ir.twitter.utility.ApplicationContext;
import org.junit.jupiter.api.*;

import java.util.List;
// OBE BY ONE TEST IS WORK
public class LikeTest {


    private static Like like1;
    private static Account account1;
    private static Account account2;
    private static Tweet tweet1;


    @BeforeAll
    static void beforeAllTest() {
        account1 = new Account(1L, "ebrahim1", "ebi1@gmail.com", "123456789", null,
                null, null, null, null);
        account2 = new Account(2L, "ebrahim2", "ebi2@gmail.com", "123456789", null,
                null, null, null, null);
        tweet1 = new Tweet(1L, "this is a tweet1", null, null, account2);
        like1 = new Like(account1, tweet1);
    }

    @BeforeEach
    void addToDatabase(){
        ApplicationContext.getAccountService().addAccount(account1);
        ApplicationContext.getAccountService().addAccount(account2);
        ApplicationContext.getTweetService().addTweet(tweet1);
        ApplicationContext.getLikeService().makeLike(like1);
    }

    @Test
    void likeTweet() {
        Assertions.assertEquals(1L, ApplicationContext.getLikeService().countOfLikes(3L));
    }
    @Test
    void disLike(){
        ApplicationContext.getLikeService().dislike(like1);
        Assertions.assertEquals(0, ApplicationContext.getLikeService().countOfLikes(3L));

    }
    @Test
    void countOfTweetLike(){
        Assertions.assertEquals(1, ApplicationContext.getLikeService().countOfLikes(3L));
    }

//    @AfterEach
//    void removeFromDatabase(){
//        ApplicationContext.getAccountService().removeAccount(account1);
//        ApplicationContext.getAccountService().removeAccount(account2);
//        ApplicationContext.getTweetService().removeTweet(tweet1.getId());
//        ApplicationContext.getLikeService().dislike(like1);
//    }
}
