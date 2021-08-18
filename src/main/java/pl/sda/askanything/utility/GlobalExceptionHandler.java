package pl.sda.askanything.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.askanything.exception.EmptyQuestionException;
import pl.sda.askanything.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyQuestionException.class)
    public Error handleEmptyQuestionException(final EmptyQuestionException exception) {
        return new Error(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Error handleUserNotFoundException(final UserNotFoundException exception) {
        return new Error(exception.getMessage());
    }
}
