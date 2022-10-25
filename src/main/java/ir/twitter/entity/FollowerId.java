package ir.twitter.entity;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class FollowerId implements Serializable {

    private Account account;
    private Account follower;

}
