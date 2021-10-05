package pl.sda.askanything.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.askanything.entity.Response;
import pl.sda.askanything.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    public static final int MIN_QUESTION_LENGTH = 2;
    public static final int MAX_QUESTION_LENGTH = 500;
    private Long id;

    private User asker;

    private List<Response> responses;

    @NotBlank(message = "Question text can not be empty")
    @Size(
            min = MIN_QUESTION_LENGTH,
            max = MAX_QUESTION_LENGTH,
            message = "Question length must be between " + MIN_QUESTION_LENGTH + " and " + MAX_QUESTION_LENGTH
    )
    @JsonProperty("text")
    private String text;

    private LocalDate date;

    public QuestionDto(long questionId, User user, String text) {

    }
}
