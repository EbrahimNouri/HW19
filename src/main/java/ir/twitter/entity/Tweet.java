package ir.twitter.entity;

import lombok.*;

import java.util.List;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 280)
    private String message;

    @OneToMany(mappedBy = "tweet")
    private List<Replay> replayList;

    @OneToMany(mappedBy = "tweet")
    private List<Like> like;
    @ManyToOne
    private Account account;


    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", account=" + account +
                '}';
    }
}
