package ir.twitter.repository.tweetRepository;

import ir.twitter.dto.ReplayDto;
import ir.twitter.dto.UsernameTweetDto;
import ir.twitter.entity.Replay;
import ir.twitter.entity.Tweet;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<UsernameTweetDto> usernameTweetDtos = new ArrayList<>();
        UsernameTweetDto usernameTweetDto = new UsernameTweetDto();
        ReplayDto replayDto = new ReplayDto();
        List<ReplayDto> replayDtoFinal = new ArrayList<>();

        List<Tweet> from_tweet = session.createQuery("from Tweet", Tweet.class).getResultList();
        List<Replay> fromReplay = session.createQuery("from Replay", Replay.class).getResultList();
        for (Tweet tw : from_tweet) {

            for (Replay replay : fromReplay) {
                if (Objects.equals(tw.getId(), replay.getTweet().getId())) {
                    replayDto.setUsername(replay.getAccount().getUserName());
                    replayDto.setText(replay.getComment());
                    replayDtoFinal.add(replayDto);
                    replayDto = new ReplayDto();
                }
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
