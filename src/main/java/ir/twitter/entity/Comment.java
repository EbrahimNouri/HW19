package ir.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass ( CommentId.class )
public class Comment {

    @Id
    @ManyToOne()
    private Account account;
    @Column(length=280)
    private String comment;
    @Id
    @ManyToOne
    private Tweet tweet;

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
