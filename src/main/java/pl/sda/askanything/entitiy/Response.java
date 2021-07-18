package pl.sda.askanything.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private Long responseId;

    @OneToOne
    private User responder;

    private String response;

    @ManyToOne
    private Question question;

    @ManyToOne
    private CommentToResponse comment;

    private LocalDate date;

    private Integer rating;
}
