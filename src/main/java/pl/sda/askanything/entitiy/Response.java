package pl.sda.askanything.entitiy;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Response {

    @Id
    @Column(name = "response_id")
    private Long responseId;

    private String response;

    @OneToMany(mappedBy = "response")
    @Column(name = "question_id")
    private List<Question> questions;

    @ManyToOne
    @Column(name ="comment_to_response_id")
    private CommentToResponse comment;

    private LocalDate date;

    private Integer rating;
}
