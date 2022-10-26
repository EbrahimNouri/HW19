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
public class Replay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    private Account account;
    @Column(length = 280)
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
    private Tweet tweet;

    @ManyToOne(fetch = FetchType.EAGER)
    private Replay replay;

    ReplayType replayType;

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }

}
