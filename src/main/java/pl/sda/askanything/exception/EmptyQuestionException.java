package pl.sda.askanything.exception;

public class EmptyQuestionException extends RuntimeException {

    public EmptyQuestionException() {    }

    public EmptyQuestionException(String message) {
        super(message);
    }
}