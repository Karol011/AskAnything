package pl.sda.askanything.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "question_id")
    private Long questionId;

    @OneToOne
    @Column(name = "user_id")
    private User asker;

    private String text;

    private LocalDate date;
}
