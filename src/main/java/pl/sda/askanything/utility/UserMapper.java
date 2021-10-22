package pl.sda.askanything.utility;

import org.mapstruct.Mapper;
import pl.sda.askanything.dto.UserDto;
import pl.sda.askanything.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
