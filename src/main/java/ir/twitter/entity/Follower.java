package ir.twitter.entity;

import lombok.*;

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
