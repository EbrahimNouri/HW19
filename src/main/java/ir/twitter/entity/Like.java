package ir.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LikeId.class)
@Table(name = "Likes")
public class Like {
    @Id
    @ManyToOne
    private Account account;
    @Id
    @ManyToOne
    private Tweet tweet;


}
