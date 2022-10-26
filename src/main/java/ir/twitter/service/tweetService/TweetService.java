package ir.twitter.service.tweetService;

import ir.twitter.dto.UsernameTweet;
import ir.twitter.entity.Account;
import ir.twitter.entity.Tweet;

import java.util.List;

public interface TweetService {
    void addTweet(Tweet tweet);
    void editTweet(Tweet tweet);
    void removeTweet(Long id);
    List<Tweet> showAllTweetOfAnAccount(Long account);
    List<Tweet> showAllTweet();
    List<UsernameTweet> showAllTweetDTO();

}
