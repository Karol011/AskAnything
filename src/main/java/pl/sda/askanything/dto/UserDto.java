package pl.sda.askanything.dto;

import lombok.NonNull;
import pl.sda.askanything.entity.Response;


public class UserDto {

    @NonNull
    private String name;

    @NonNull
    private String email;

    private Response response;
}
