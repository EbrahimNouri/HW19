package ir.twitter.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@IdClass(FollowerId.class)
public class Follower {
    @Id
    @ManyToOne
    private Account account;
    @Id
    @ManyToOne
    private Account follower;

}
