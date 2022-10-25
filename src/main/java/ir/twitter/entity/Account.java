package ir.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;

    private String email;

    private String password;
    @OneToMany(mappedBy = "account")
    private List<Replay> replayList;
    @OneToMany(mappedBy = "account")
    private List<Like> like;
    @OneToMany(mappedBy = "account")
    private List<Tweet> tweets;

    @OneToMany(mappedBy = "follower")
    private List<Follower> followers;

    @OneToMany(mappedBy = "following")
    private List<Following> followings;


}
