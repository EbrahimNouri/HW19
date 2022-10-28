package ir.twitter.repository.tweetRepository;

import ir.twitter.dto.ReplayDto;
import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.entity.Replay;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TweetRepositoryImpl implements TweetRepository {

    public void save(Session session, Tweet tweet) {
        session.save(tweet);
    }

    @Override
    public Optional<Tweet> find(Session session, Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Tweet>> findAll(Session session, Long aLong) {
        return Optional.ofNullable(session.createQuery("from Tweet").getResultList());
    }

    @Override
    public void update(Session session, Tweet tweet) {
        session.update(tweet);
    }


    public Optional<Tweet> findBYId(Session session, Long id) {
        return Optional.ofNullable(session.find(Tweet.class, id));
    }


    public void delete(Session session, Long id) {

        String hql = "delete from Tweet a where a.id =:id";

        session.createQuery(hql).setParameter("id", id).executeUpdate();

    }

    @Override
    public Optional<List<Tweet>> showAll(Session session) {
        return Optional.ofNullable(session.createQuery("from Tweet ", Tweet.class).getResultList());
    }

    @Override
    public List<UsernameTweetDto> showAllTweetDTO(Session session) {
//
//
        List<UsernameTweetDto> usernameTweetDtos = new ArrayList<>();
        UsernameTweetDto usernameTweetDto = new UsernameTweetDto();
        ReplayDto replayDto = new ReplayDto();
        List<ReplayDto> replayDtoFinal = new ArrayList<>();
//
//
//        List<Tweet> resultList = Optional.ofNullable
//                (session.createQuery
//                        ("from Tweet t", Tweet.class).getResultList()).orElseThrow();
//
//        for (Tweet tweet : resultList) {
//
//            usernameTweetDto.setUsername(tweet.getAccount().getUserName());
//
//            usernameTweetDto.setTweet(tweet.getMessage());
//
//            Long countOfLikes = session
//                    .createQuery("select count(l) from Like l where  l.tweet.id = :tweetId", Long.class)
//                    .setParameter("tweetId", tweet.getId()).getSingleResult();
//            usernameTweetDto.setCountOfLikes(countOfLikes);
//
//            List<Replay> replays = session.createQuery("from Replay r where r.tweet.id = :tweetId", Replay.class)
//                    .setParameter("tweetId", tweet.getId()).getResultList();
//            for (Replay rp : replays) {
//                replayDto.setUsername(rp.getAccount().getUserName());
//                replayDto.setText(rp.getComment());
//                replayDtoFinal.add(replayDto);
//            }
//            usernameTweetDto.setReplaysDto(replayDtoFinal);
//
//            usernameTweetDtos.add(usernameTweetDto);
//
//        }
        List<Tweet> from_tweet = session.createQuery("from Tweet", Tweet.class).getResultList();
        for (Tweet tw : from_tweet) {
            List<Replay> tempTweetList = session.createQuery("from Replay r where r.tweet.id = :twId", Replay.class).
                    setParameter("twId", tw.getId()).getResultList();
            for (Replay rp : tempTweetList) {
                replayDto.setUsername(rp.getAccount().getUserName());
                replayDto.setText(rp.getComment());
                replayDtoFinal.add(replayDto);
                replayDto = new ReplayDto();
            }
            usernameTweetDto.setReplaysDto(replayDtoFinal);
            usernameTweetDto.setUsername(tw.getAccount().getUserName());
            usernameTweetDto.setTweet(tw.getMessage());
            usernameTweetDto.setCountOfLikes((long) tw.getLike().size());
            usernameTweetDtos.add(usernameTweetDto);
            usernameTweetDto = new UsernameTweetDto();
            replayDtoFinal = new ArrayList<>();

        }
        return usernameTweetDtos;
    }

    @Override
    public Optional<Tweet> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Tweet.class, id));
    }


}
