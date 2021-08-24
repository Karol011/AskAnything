package pl.sda.askanything.utility;

import org.mapstruct.Mapper;
import pl.sda.askanything.dto.QuestionDto;
import pl.sda.askanything.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDto toDto(Question question);

    Question toEntity(QuestionDto questionDto);
}
