package ir.twitter.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsernameTweetDto {

    String username;

    String tweet;

    Long countOfLikes;

    List<ReplayDto> replaysDto;

}
