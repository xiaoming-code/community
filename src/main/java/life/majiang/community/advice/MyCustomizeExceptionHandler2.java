package life.majiang.community.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyCustomizeExceptionHandler2
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Throwable ex) {

        return null;
    }
}
