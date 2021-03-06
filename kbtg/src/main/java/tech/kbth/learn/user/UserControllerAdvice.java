package tech.kbth.learn.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(Exception e){
        ErrorResponse response = new ErrorResponse(1234, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
