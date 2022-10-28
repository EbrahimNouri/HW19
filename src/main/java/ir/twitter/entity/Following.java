package ir.twitter.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FollowingId.class)
public class Following {
    @Id
    @OneToOne
    private Account account;
    @Id
    @ManyToOne
    private Account following;

}
