package ir.twitter.dto;

import ir.twitter.entity.Replay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsernameTweet {

    String username;

    String tweet;

    Long countOfLikes;

    List<Replay> replays;

}
