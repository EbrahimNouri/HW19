package ir.twitter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(FollowingId.class)
public class Following {
    @Id
    @OneToOne
    private Account account;
    @Id
    @ManyToOne
    private Account following;

}
