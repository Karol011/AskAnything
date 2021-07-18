package pl.sda.askanything.entitiy;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment_to_response")
public class CommentToResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "comment_to_response_id")
    private Long commentId;

    private String text;

    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private User commentator;

    @OneToMany(mappedBy = "response")
    private List<Response> responses;
}
