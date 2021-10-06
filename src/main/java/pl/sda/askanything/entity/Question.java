package pl.sda.askanything.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Question extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User asker;

    @OneToMany(mappedBy = "question")
    private List<Response> responses;

    private String text;

    public Question(User asker, List<Response> responses, String text) {
        super();
        this.asker = asker;
        this.responses = responses;
        this.text = text;
    }
}
