package ir.twitter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FollowerId implements Serializable {

    private Account account;
    private Account follower;

}
