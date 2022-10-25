package ir.twitter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class FollowingId implements Serializable {

    private Account account;
    private Account following;

}
