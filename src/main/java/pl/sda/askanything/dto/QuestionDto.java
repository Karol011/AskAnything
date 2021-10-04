package pl.sda.askanything.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.askanything.entity.Response;
import pl.sda.askanything.entity.User;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;

    private User asker;

    private List<Response> responses;

    @NotBlank(message = "Question text can not be empty")
    @JsonProperty("text")
    private String text;

    private LocalDate date;

    public QuestionDto(long questionId, User user, String text) {

    }
}
