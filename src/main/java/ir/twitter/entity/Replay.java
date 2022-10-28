package ir.twitter.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Replay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    @Column(length = 280)
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
    private Tweet tweet;

    @ManyToOne(fetch = FetchType.EAGER)
    private Replay replay;

    private ReplayType replayType;

}
