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
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private User commentator;

    @OneToMany(mappedBy = "response")
    private List<Response> responses;
}
