package ir.twitter.service.tweetService;

import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    void addTweet(Tweet tweet);
    void editTweet(Tweet tweet);
    void removeTweet(Long id);
    List<Tweet> showAllTweetOfAnAccount(Long account);
    List<Tweet> showAllTweet();
    List<UsernameTweetDto> showAllTweetDTO();

    Tweet findById(Long id);


}
