package pl.sda.askanything.entitiy;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User asker;

    @OneToMany(mappedBy = "question")
    private List<Response> responses;

    private String text;

    private LocalDate date;
}
