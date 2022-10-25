package ir.twitter.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
public class LikeId implements Serializable {

    private Account account;

    private Tweet tweet;

    public LikeId() {
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals ( account,likeId.account ) && Objects.equals ( tweet,likeId.tweet );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( account,tweet );
    }

    public LikeId( Account account,Tweet tweet ) {
        this.account = account;
        this.tweet = tweet;
    }
}
