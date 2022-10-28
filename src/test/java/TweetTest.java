import ir.twitter.dto.ReplayDto;
import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.entity.*;
import ir.twitter.utility.ApplicationContext;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TweetTest {

    private static Account account1;
    private static Account account2;
    private static Tweet tweet1;
    private static Like like1;
    private static Replay replay1;


    @BeforeAll
    static void initialize() {

        account1 = new Account(1L, "ebrahim1", "ebi1@gmail.com", "123456789", null,
                null, null, null, null);
        account2 = new Account(2L, "ebrahim2", "ebi2@gmail.com", "123456789", null,
                null, null, null, null);
        tweet1 = new Tweet(1L, "this is a tweet1", null, null, account2);
        like1 = new Like(account1, tweet1);
        replay1 = new Replay(null, account1, "this is a replay for a tweet", tweet1,
                null, ReplayType.TWEET);


    }

    @BeforeEach
    void initialInDatabase() {
        ApplicationContext.getAccountService().addAccount(account1);
        ApplicationContext.getAccountService().addAccount(account2);
        ApplicationContext.getTweetService().addTweet(tweet1);
        ApplicationContext.getLikeService().makeLike(like1);
        ApplicationContext.getReplayService().addReplay(replay1);

    }

    @Test
    void showAllTweetOFOneAccount() {
        List<UsernameTweetDto> usernameTweetDtos = ApplicationContext.getTweetService().showAllTweetDTO();
        System.out.println(usernameTweetDtos.get(0));
    }

    @Test
    void showAllTestClassic() {
        List<Tweet> tweet = ApplicationContext.getTweetService().showAllTweet();
        ReplayDto replayDto = new ReplayDto(
                ApplicationContext.getReplayService()
                        .showAllReplayOfTweet(3).get(0).getComment()
                , ApplicationContext.getReplayService()
                .showAllReplayOfTweet(3).get(0).getAccount().getUserName());
        List<ReplayDto> replayDtoList = new ArrayList<>();
        replayDtoList.add(replayDto);


        UsernameTweetDto usernameTweetDto = new UsernameTweetDto(
                tweet.get(0).getAccount().getUserName(),
                tweet.get(0).getMessage(),
                ApplicationContext.getLikeService().countOfLikes(3L), replayDtoList
        );


        Assertions.assertEquals("ebrahim2", usernameTweetDto.getUsername());
        Assertions.assertEquals(1, usernameTweetDto.getCountOfLikes());
        Assertions.assertEquals("this is a tweet1", usernameTweetDto.getTweet());
        Assertions.assertEquals("this is a replay for a tweet", usernameTweetDto.getReplaysDto().get(0).getText());
        Assertions.assertEquals("ebrahim1", usernameTweetDto.getReplaysDto().get(0).getUsername());
    }

    @Test
    void showAllTest() {
        List<UsernameTweetDto> usernameTweetDtos = ApplicationContext.getTweetService().showAllTweetDTO();
        Assertions.assertEquals("ebrahim2", usernameTweetDtos.get(0).getUsername());
        Assertions.assertEquals(1, usernameTweetDtos.get(0).getCountOfLikes());
        Assertions.assertEquals("this is a tweet1", usernameTweetDtos.get(0).getTweet());
        Assertions.assertEquals("this is a replay for a tweet", usernameTweetDtos.get(0).getReplaysDto().
                get(0).getText());
        Assertions.assertEquals("ebrahim1", usernameTweetDtos.get(0).getReplaysDto().get(0).getUsername());
    }

    @Test
    void updateTweet(){
        tweet1.setMessage("hello");
        ApplicationContext.getTweetService().editTweet(tweet1);
        Assertions.assertEquals("hello", ApplicationContext.getTweetService().findById(3L).getMessage());
    }
}
