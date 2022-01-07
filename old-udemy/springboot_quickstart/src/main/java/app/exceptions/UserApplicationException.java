package app.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserApplicationException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyExceptions(Exception exception, WebRequest webRequest) {
        UserApplicationErrorMessage errorMessage = new UserApplicationErrorMessage(new Date(),
                exception.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> handleNullPointerExceptions(NullPointerException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
