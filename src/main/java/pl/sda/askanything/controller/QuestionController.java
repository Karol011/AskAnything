package pl.sda.askanything.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.askanything.dto.QuestionDto;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.service.QuestionService;
import pl.sda.askanything.utility.QuestionMapper;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @PostMapping()
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDto questionDto) {

            return new ResponseEntity<>(
                    questionService.save(
                            questionMapper.toEntity(questionDto)),
                    HttpStatus.CREATED);
    }
}
