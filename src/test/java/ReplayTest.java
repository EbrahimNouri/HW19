import ir.twitter.entity.*;
import ir.twitter.utility.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReplayTest {
    private static Like like1;
    private static Account account1;
    private static Account account2;
    private static Tweet tweet1;

    private static Replay replay1;
    private static Replay replay2;

    private static Long tempReplayId1;

    @BeforeAll
    static void beforeAllTest() {
        account1 = new Account(1L, "ebrahim1", "ebi1@gmail.com", "123456789", null,
                null, null, null, null);
        account2 = new Account(2L, "ebrahim2", "ebi2@gmail.com", "123456789", null,
                null, null, null, null);
        tweet1 = new Tweet(1L, "this is a tweet1", null, null, account2);
        like1 = new Like(account1, tweet1);
        replay1 = new Replay(null, account1, "this is a replay for a tweet", tweet1,
                null, ReplayType.TWEET);
        replay2 = new Replay(null, account1, "this is a replay for a replay", null,
                replay1, ReplayType.REPLAY);

    }

    @BeforeEach
    void addToDatabase(){
        ApplicationContext.getAccountService().addAccount(account1);
        ApplicationContext.getAccountService().addAccount(account2);
        ApplicationContext.getTweetService().addTweet(tweet1);
        ApplicationContext.getLikeService().makeLike(like1);
        ApplicationContext.getReplayService().addReplay(replay1);
        ApplicationContext.getReplayService().addReplay(replay2);
    }

    @Test
    void replayOfTweetTest(){
        Assertions.assertEquals("this is a replay for a tweet", ApplicationContext.getReplayService()
                .showAllReplayOfTweet(3L).get(0).getComment());
    }

    @Test
    void replayOfReplayTest(){
        Assertions.assertEquals("this is a replay for a replay", ApplicationContext.getReplayService()
                .showAllReplayOfReplay(1L).get(0).getComment());
    }

    @Test
    void editReplay(){
        ApplicationContext.getReplayService().editReplay(replay1, "this replay message is edited");
        Assertions.assertEquals("this replay message is edited", ApplicationContext.getReplayService()
                .showAllReplayOfTweet(3L).get(0).getComment());
    }

}
