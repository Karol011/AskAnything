package pl.sda.askanything.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.askanything.entity.Response;
import pl.sda.askanything.entity.User;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;

    private User asker;

    private List<Response> responses;

    private String text;

    private LocalDate date;

    public QuestionDto(long questionId, User user, String text) {

    }
}
