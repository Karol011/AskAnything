package pl.sda.askanything.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
