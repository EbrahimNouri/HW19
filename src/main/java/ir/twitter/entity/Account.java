package ir.twitter.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}",
            message = "Please provide a valid email address")
    private String email;

    @Size(min = 8, max = 100, message = "password is invalid")
    private String password;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<Replay> replayList;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<Like> like;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<Tweet> tweets;

    @OneToMany(mappedBy = "follower")
    @ToString.Exclude
    private List<Follower> followers;

    @OneToMany(mappedBy = "following")
    @ToString.Exclude
    private List<Following> followings;


}
