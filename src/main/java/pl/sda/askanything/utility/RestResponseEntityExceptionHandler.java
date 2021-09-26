package pl.sda.askanything.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.sda.askanything.exception.EmptyQuestionException;
import pl.sda.askanything.exception.ExceptionResponse;
import pl.sda.askanything.exception.UserNotFoundException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyQuestionException.class)
    public ResponseEntity<Object> handleEmptyQuestionException(final EmptyQuestionException exception) {
        return buildResponseEntity(new ExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(final UserNotFoundException exception) {
        return buildResponseEntity(new ExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exceptionResponse) {
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }
}
