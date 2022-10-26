package ir.twitter.repository.followerRepository;

import ir.twitter.entity.Account;
import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Follower;
import ir.twitter.entity.FollowerId;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends BaseRepository<Follower, Follower> {
    Optional<List<Follower>> showAll(Session session, Long accId);
}
