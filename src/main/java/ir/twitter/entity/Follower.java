package ir.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@IdClass(FollowerId.class)
public class Follower {

    @Id
    @ManyToOne
    private Account account;

    @Id
    @ManyToOne
    private Account follower;

}
