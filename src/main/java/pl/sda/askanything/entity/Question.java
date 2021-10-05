package pl.sda.askanything.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User asker;

    @OneToMany(mappedBy = "question")
    private List<Response> responses;

    private String text;

    private LocalDate date;

    public Question(Long id, User asker, List<Response> responses, String text) {
        this.id = id;
        this.asker = asker;
        this.responses = responses;
        this.text = text;
        this.date = LocalDate.now();
    }
}
