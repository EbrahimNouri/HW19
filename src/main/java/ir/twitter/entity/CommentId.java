package ir.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class CommentId implements Serializable {

    private Account account;

    private Tweet tweet;


    public CommentId(){}

    public CommentId( Account account,Tweet tweet ) {
        this.account = account;
        this.tweet = tweet;
    }



    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        CommentId commentId = (CommentId) o;
        return Objects.equals ( account,commentId.account ) && Objects.equals ( tweet,commentId.tweet );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( account,tweet );
    }
}
