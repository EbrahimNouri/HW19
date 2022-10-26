package ir.twitter.service.likeService;

import ir.twitter.entity.Like;

public interface LikeService {
    void makeLike(Like like);
    void dislike(Like like);
    Long countOfLikes(Long tweetId);

}
