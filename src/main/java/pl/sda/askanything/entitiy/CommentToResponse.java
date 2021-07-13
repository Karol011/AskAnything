package pl.sda.askanything.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "comment_to_response")
public class CommentToResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "comment_to_response_id")
    private Long commentId;

    private String text;

    @OneToMany(mappedBy = "user")
    @Column(name = "user_id")
    private List<User> commentators;

    @OneToMany(mappedBy = "response")
    @Column(name = "response_id")
    private List<Response> responses;
}
